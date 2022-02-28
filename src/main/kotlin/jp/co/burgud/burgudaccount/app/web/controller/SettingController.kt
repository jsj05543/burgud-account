package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.SystemUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.UserUseCase
import jp.co.burgud.burgudaccount.app.web.form.AuthSettingForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("userSetting")
class SettingController(
    private val userUseCase: UserUseCase,
    private val authorityRepository: AuthorityRepository,
    private val systemUseCase: SystemUseCase,
    private val userRepository: UserRepository
) {
    @GetMapping
    fun index(
        model: Model,
        @CookieValue(value = "id", required = false) sid: String?

    ): String {
        sid ?: return "redirect:/login"
        val loginSession = systemUseCase.findSession(sid) ?: return "redirect:/login"
        val loginUser = userRepository.getUserName(loginSession.userCd)
        model.addAttribute("userName", loginUser)
        val certification = userUseCase.getOneUserCertification(loginSession.userCd)
        val form = AuthSettingForm(
            certification.userCd,
            certification.authorityKbn
        )
        model.addAttribute("form", form)
        model.addAttribute("authorList", authorityRepository.getAllAuthority())
        return "brgd0140_userSetting.html"
    }

    @PostMapping
    fun index(
        model: Model,
        @RequestParam("userCd") userCd: String,
        @CookieValue(value = "id", required = false) sid: String?
    ): String {
        sid ?: return "redirect:/login"
        val loginSession = systemUseCase.findSession(sid) ?: return "redirect:/login"
        val loginUser = userRepository.getUserName(loginSession.userCd)
        model.addAttribute("userName", loginUser)
        val certification = userUseCase.getOneUserCertification(userCd)
        val form = AuthSettingForm(
            certification.userCd,
            certification.authorityKbn
        )
        model.addAttribute("form", form)
        model.addAttribute("authorList", authorityRepository.getAllAuthority())
        return "brgd0140_userSetting"
    }

    @PostMapping(params = ["setting"])
    fun updateUser(
        model: Model,
        @Validated form: AuthSettingForm,
        @CookieValue(value = "id", required = false) sid: String?
    ): String {
        sid ?: return "redirect:/login"
        val loginSession = systemUseCase.findSession(sid) ?: return "redirect:/login"
        val loginUser = userRepository.getUserName(loginSession.userCd)
        model.addAttribute("userName", loginUser)
        userUseCase.updateUserAuth(
            userCd = form.userCd,
            authorityKbn = form.authorityKbn,
            loginUser = loginUser
        )
        model.addAttribute("form", form)
        model.addAttribute("authorList", authorityRepository.getAllAuthority())
        model.addAttribute("success", true)
        return "brgd0140_userSetting"
    }
}