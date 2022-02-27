package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.entity.Account
import jp.co.burgud.burgudaccount.app.domain.repository.AccountRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.AccountUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.CountryUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.FacilityUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.PrefAndCityUseCase
import jp.co.burgud.burgudaccount.app.web.form.AccountForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("account")
class AccountController(
    private val accountUseCase: AccountUseCase,
    private val countryUseCase: CountryUseCase,
    private val facilityUseCase: FacilityUseCase

) {
    companion object {
        private const val COUNTRYKBN_JAPAN = "CY04"

        private const val FACILITYKBN_NET = "FY01"

        private const val MODE_SHOW = "show"

        private const val MODE_EDIT = "edit"

        private const val MODE_NEW = "new"
    }

    @GetMapping
    fun index(model: Model): String {
        val accountList = accountUseCase.getAllAccount()
        val accountForm = AccountForm(accountList = accountList)
        model.addAttribute("countryData", countryUseCase.getCountryData())
        model.addAttribute("facilityData", facilityUseCase.getFacilityData())
        model.addAttribute("listSize", accountList.size)
        model.addAttribute("countryKbn", "")
        model.addAttribute("keyword", "")
        model.addAttribute("accountForm", accountForm)
        return "brgd0020_account"
    }

    @PostMapping(params = ["search"])
    fun searchAccount(
        model: Model,
        @RequestParam("countryKbn") countryKbn: String,
        @RequestParam("keyword") keyword: String
    ): String {
        val accountList = accountUseCase.searchAccount(countryKbn, keyword)

        val accountForm = AccountForm(accountList = accountList)
        model.addAttribute("listSize", accountList.size)
        model.addAttribute("countryKbn", "")
        model.addAttribute("keyword", "")
        model.addAttribute("accountForm", "")
        return "brgd0020_account"
    }

    @GetMapping("new")
    fun newAccount(model: Model): String {
        val account = Account(
            accountCd = accountUseCase.createNewAccountCd(),
            accountUsedName = "",
            usedDetail = "",
            accountName = "",
            accountPassword = "",
            countryKbn = COUNTRYKBN_JAPAN,
            facilityKbn = FACILITYKBN_NET,
            query1 = null,
            answer1 = null,
            query2 = null,
            answer2 = null,
            query3 = null,
            answer3 = null,
            oldPassword1 = null,
            oldPassword2 = null,
            oldPassword3 = null,
            biko = null,
            createUser = null,
            createDateTime = null,
            updateUser = null,
            updateDateTime = null
        )
        addAttribute(model, account, MODE_NEW)
        return "brgd0030_detail"
    }

    @GetMapping("{accountCd}")
    fun showUser(model: Model, @PathVariable("accountCd") accountCd: String): String {
        val account = accountUseCase.getOneAccount(accountCd)
        addAttribute(model, account, MODE_SHOW)
        return "brgd0030_detail"
    }

    @GetMapping("{accountCd}/edit")
    fun editUser(model: Model, @PathVariable("accountCd") accountCd: String): String {
        val account = accountUseCase.getOneAccount(accountCd)
        addAttribute(model, account, MODE_EDIT)
        return "brgd0030_detail"
    }

    private fun addAttribute(model: Model, account: Account, mode: String) {
        model.addAttribute("accountForm", account)
        model.addAttribute("countryData", countryUseCase.getCountryData())
        model.addAttribute("facilityData", facilityUseCase.getFacilityData())
        model.addAttribute("questionData", accountUseCase.getQuestionData())
        model.addAttribute("answerData", accountUseCase.getAnswerData())
        when (mode) {
            MODE_NEW ->
                model.addAttribute("mode", MODE_NEW)
            MODE_EDIT ->
                model.addAttribute("mode", MODE_EDIT)
            MODE_SHOW ->
                model.addAttribute("mode", MODE_SHOW)
        }
    }
}