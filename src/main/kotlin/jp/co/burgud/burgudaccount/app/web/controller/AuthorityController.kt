package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.AuthorityUseCase
import jp.co.burgud.burgudaccount.app.web.form.AuthorityEditForm
import jp.co.burgud.burgudaccount.app.web.form.AuthorityForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("authority")
class AuthorityController(
    private val authorityRepository: AuthorityRepository,
    private val authorityUseCase: AuthorityUseCase

) {
    @GetMapping
    fun index(
        model: Model,
        @CookieValue(value = "id", required = false) sid: String?
    ): String {
        sid ?: return "redirect:/login"
        val form = AuthorityEditForm(
            authorityList = authorityRepository.getAllAuthority()
        )
        model.addAttribute("form", form)
        return "brgd0080_authority"
    }

    @PostMapping(params = ["cancel"])
    fun cancel(
        model: Model,
        @CookieValue(value = "id", required = false) sid: String?
    ): String {
        sid ?: return "redirect:/login"
        return index(model, sid)
    }

    @PostMapping(params = ["update"])
    fun updateAuthority(
        model: Model,
        @Validated form: AuthorityEditForm,
        @CookieValue(value = "id", required = false) sid: String?,
        result: BindingResult
    ): String {
        sid ?: return "redirect:/login"
        model.addAttribute("form", form)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            model.addAttribute("mode", "update")
            return "brgd0080_authority"
        }
        authorityUseCase.update(form.authorityList, loginUser = "hakuei_update")
        model.addAttribute("success", true)
        return index(model, sid)
    }

    @GetMapping("new")
    fun newAurhority(
        model: Model,
        @CookieValue(value = "id", required = false) sid: String?,
    ): String {
        sid ?: return "redirect:/login"
        val form = AuthorityForm(
            authorityKbn = authorityUseCase.createNewAuthorityKbn(),
            authorityName = null
        )
        model.addAttribute("form", form)
        return "brgd0081_authority.html"
    }

    @PostMapping(params = ["insert"])
    fun createAuthority(
        model: Model,
        @Validated form: AuthorityForm,
        @CookieValue(value = "id", required = false) sid: String?,
        result: BindingResult
    ): String {
        sid ?: return "redirect:/login"
        model.addAttribute("form", form)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            return "brgd0081_authority"
        }
        authorityUseCase.create(
            authorityKbn = form.authorityKbn,
            authorityName = form.authorityName,
            loginUser = "hakuei_create"
        )
        model.addAttribute("success", true)
        return index(model, sid)
    }
}