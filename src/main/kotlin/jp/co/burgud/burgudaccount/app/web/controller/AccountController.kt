package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.entity.Account
import jp.co.burgud.burgudaccount.app.domain.repository.AccountRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.AccountUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.CountryUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.FacilityUseCase
import jp.co.burgud.burgudaccount.app.web.form.AccountForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("account")
class AccountController(
    private val accountUseCase: AccountUseCase,
    private val countryUseCase: CountryUseCase,
    private val facilityUseCase: FacilityUseCase,
    private val accountRepository: AccountRepository,

    ) {
    @GetMapping
    fun index(model: Model): String {
        val accountList: List<Account> = accountRepository.getAllAccount()
        val accountForm = AccountForm(accountList)
        model.addAttribute("listSize", accountList.size)
        model.addAttribute("countryKbn", "")
        model.addAttribute("keyword", "")
        addAttribute(model, accountForm, "")
        return "brgd0020_account"
    }

    @GetMapping("new")
    fun newAccount(model: Model): String {
      //  val accountForm = AccountForm(
      //      Account(accountUseCase.createNewAccountCd(), COUNTRYKBN_JAPAN, FACILITYKBN_NET)
      //  )
       // addAttribute(model!!, accountForm, MODE_NEW)
        return "brgd0030_detail"
    }

    private fun addAttribute(model: Model, accountForm: AccountForm, mode: String) {
        model.addAttribute("accountForm", accountForm);
        model.addAttribute("countryData", countryUseCase.getCountryData());
        model.addAttribute("facilityData", facilityUseCase.getFacilityData());
    }
}