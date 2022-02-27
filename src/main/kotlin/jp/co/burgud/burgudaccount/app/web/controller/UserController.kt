package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.entity.User
import jp.co.burgud.burgudaccount.app.domain.usecase.PrefAndCityUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.SystemUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.UserUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@Controller
@RequestMapping("user")
class UserController(
    private val prefAndCityUseCase: PrefAndCityUseCase,
    private val systemUseCase: SystemUseCase,
    private val userUseCase: UserUseCase
) {
    companion object {
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
        val userList = userUseCase.getAllUser()
        model.addAttribute("userList", userList)
        model.addAttribute("sexData", systemUseCase.getSexData())
        model.addAttribute("prefData", prefAndCityUseCase.getPrefData())
        model.addAttribute("cityData", prefAndCityUseCase.getCityData())
        return "brgd0050_user"
    }

    @GetMapping("{userCd}")
    fun showUser(model: Model, @PathVariable("userCd") userCd: String): String {
        addAttribute(model, userUseCase.getOneUser(userCd), MODE_SHOW)
        return "brgd0051_user"
    }

    @GetMapping("new")
    fun newUser(model: Model): String {
        val user = User(
            userCd = userUseCase.createNewUserCd(),
            email = "",
            firstName = "",
            lastName = "",
            sex = SEX_MEN,
            birth = "",
            tel = "",
            zip = "",
            address = "",
            nutagPref = NUTAGCITY_TOKYO.toString(),
            nutagCity = "",
            sendMailFlg = SENDMAILFLAG_OFF,
            createUser = "AA",
            createAt = LocalDateTime.now(),
            updateUser = null,
            updateAt = null
        )
        addAttribute(model, user, MODE_NEW)
        return "brgd0051_user"
    }

    @GetMapping("{userCd}/edit")
    fun editUser(model: Model, @PathVariable("userCd") userCd: String): String {
        addAttribute(model, userUseCase.getOneUser(userCd), MODE_EDIT)
        return "brgd0051_user"
    }

    @PostMapping(params = ["insert"])
    fun createUser(model: Model, @Validated user: User, result: BindingResult): String {
        addAttribute(model, user, MODE_NEW)
        if (result.hasErrors()) {
            // setError(model, result)
            return "brgd0051_user"
        }
        userUseCase.create(user, AUTHORITYKBN_ETURAN, "123456789")
        model.addAttribute("success", true)
        return "brgd0051_user"
    }

    @PutMapping
    fun updateUser(model: Model, @Validated user: User, result: BindingResult): String {
        addAttribute(model, user, MODE_EDIT)
        if (result.hasErrors()) {
            //setError(model, result)
            return "brgd0051_user"
        }
        userUseCase.update(user, loginUser = "userhakuei")
        model.addAttribute("success", true)
        return "brgd0051_user"
    }

    @DeleteMapping("{userCd}")
    fun delete(@PathVariable("userCd") userCd: String): String {
        userUseCase.delete(userCd)
        return "redirect:/user"
    }

    private fun addAttribute(model: Model, userForm: User, mode: String) {
        model.addAttribute("userForm", userForm)
        model.addAttribute("sexData", systemUseCase.getSexData())
        model.addAttribute("prefData", prefAndCityUseCase.getPrefData())
        when (mode) {
            MODE_NEW -> {
                model.addAttribute("cityList", prefAndCityUseCase.getCityByPrefCode(NUTAGCITY_TOKYO))
                model.addAttribute("mode", MODE_NEW)
            }
            MODE_EDIT -> {
                model.addAttribute("cityList", prefAndCityUseCase.getCityByPrefCode(getPagePref(userForm)))
                model.addAttribute("mode", MODE_EDIT)
            }
            MODE_SHOW -> {
                model.addAttribute("cityList", prefAndCityUseCase.getCityByPrefCode(getPagePref(userForm)))
                model.addAttribute("mode", MODE_SHOW)
            }
            else -> model.addAttribute("cityData", prefAndCityUseCase.getCityData())
        }
    }

    private fun getPagePref(userForm: User): Int {
        return userForm.nutagPref.toInt()
    }
}