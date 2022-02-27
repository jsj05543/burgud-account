package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.usecase.UserUseCase
import jp.co.burgud.burgudaccount.app.web.form.PasswordForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("password")
class PasswordResetController(
    private val userUseCase: UserUseCase
) {
    @GetMapping
    fun index(model: Model, form: PasswordForm): String {
        model.addAttribute("form", form)
        return "brgd0130_pass.html"
    }

    @PostMapping(params = ["reset"])
    fun updateUser(model: Model, @Validated form: PasswordForm, result: BindingResult): String {
        model.addAttribute("form", form)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            return "brgd0130_pass"
        }
        userUseCase.updatePassword(
            userCd = form.userCd,
            passwordNew = form.passwordNew,
            loginUser = "AAAAAAA"
        )
        model.addAttribute("success", true)
        return "brgd0130_pass"
    }
}