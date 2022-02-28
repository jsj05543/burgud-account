package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.SystemUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.UserUseCase
import jp.co.burgud.burgudaccount.app.web.form.PasswordForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("password")
class PasswordResetController(
    private val userUseCase: UserUseCase,
    private val systemUseCase: SystemUseCase,
    private val userRepository: UserRepository
) {
    @GetMapping
    fun index(
        model: Model,
        form: PasswordForm,
        @CookieValue(value = "id", required = false) sid: String?,
    ): String {
        sid ?: return "redirect:/login"
        val loginSession = systemUseCase.findSession(sid) ?: return "redirect:/login"
        val loginUser = userRepository.getUserName(loginSession.userCd)
        model.addAttribute("userName", loginUser)

        model.addAttribute("form", form)
        return "brgd0130_pass.html"
    }

    @PostMapping(params = ["reset"])
    fun updateUser(
        model: Model,
        @Validated form: PasswordForm,
        @CookieValue(value = "id", required = false) sid: String?,
        result: BindingResult
    ): String {
        sid ?: return "redirect:/login"
        model.addAttribute("form", form)
        val loginSession = systemUseCase.findSession(sid) ?: return "redirect:/login"
        val loginUser = userRepository.getUserName(loginSession.userCd)
        model.addAttribute("userName", loginUser)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            return "brgd0130_pass"
        }
        userUseCase.updatePassword(
            userCd = loginSession.userCd,
            passwordNew = form.passwordNew,
            loginUser = loginUser
        )
        model.addAttribute("success", true)
        return "brgd0130_pass"
    }
}