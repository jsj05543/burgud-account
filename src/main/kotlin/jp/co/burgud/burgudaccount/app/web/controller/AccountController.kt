package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.AccountRepository
import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.web.form.AccountForm
import jp.co.burgud.burgudaccount.common.entity.Account
import jp.co.burgud.burgudaccount.common.util.GeneralLojic
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("account")
class AccountController(
    private  val accountRepository: AccountRepository,
    private  val generalLojic: GeneralLojic
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

    private fun addAttribute(model:Model, accountForm:AccountForm, mode:String)
    {
        model.addAttribute("accountForm", accountForm);
        model.addAttribute("countryData", generalLojic.getCountryData());
        model.addAttribute("facilityData", generalLojic.getFacilityData());
    }
}