package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.PrefAndCityUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.SystemUseCase
import jp.co.burgud.burgudaccount.app.web.form.UserForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("user")
class UserController(
    private val userRepository: UserRepository,
    private val prefAndCityUseCase: PrefAndCityUseCase,
    private val systemUseCase: SystemUseCase
) {
    @GetMapping
    fun index(model: Model): String {
        val userForm = UserForm(userRepository.getAllUser())
        addAttribute(model, userForm, "");
        return "brgd0050_user"
    }

    private fun addAttribute(model: Model, userForm: UserForm, mode: String) {
        model.addAttribute("userForm", userForm)
        model.addAttribute("sexData", systemUseCase.getSexData())
        model.addAttribute("prefData", prefAndCityUseCase.getPrefData())
        model.addAttribute("cityData", prefAndCityUseCase.getCityData())
    }
}