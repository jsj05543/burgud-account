package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.entity.User
import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.PrefAndCityUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.SystemUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.UserUseCase
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
    private val systemUseCase: SystemUseCase,
    private val userUseCase: UserUseCase
) {
    companion object{
        private const val SEX_MEN = "1"

        private const val SENDMAILFLAG_OFF = ""

        private const val AUTHORITYKBN_ETURAN = "AY02"

        private const val NUTAGCITY_TOKYO = 13

        private const val MODE_SHOW = "show"

        private const val MODE_EDIT = "edit"

        private const val MODE_NEW = "new"
    }

    @GetMapping
    fun index(model: Model): String {
        val userForm = UserForm(userRepository.getAllUser())
        addAttribute(model, userForm, "");
        return "brgd0050_user"
    }

    @GetMapping("new")
    fun newUser(model: Model): String {
    //    val user =
    //        User(userUseCase.createNewUserCd(), SEX_MEN, SENDMAILFLAG_OFF, java.lang.String.valueOf(NUTAGCITY_TOKYO))
    //    addAttribute(model, user, "MODE_NEW")
        return "brgd0051_user"
    }

    private fun addAttribute(model: Model, userForm: UserForm, mode: String) {
        model.addAttribute("userForm", userForm)
        model.addAttribute("sexData", systemUseCase.getSexData())
        model.addAttribute("prefData", prefAndCityUseCase.getPrefData())
        model.addAttribute("cityData", prefAndCityUseCase.getCityData())
    }
}