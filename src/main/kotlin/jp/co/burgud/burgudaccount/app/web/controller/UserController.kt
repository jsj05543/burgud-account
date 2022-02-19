package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.web.form.UserForm
import jp.co.burgud.burgudaccount.common.util.GeneralLojic
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("user")
class UserController(
    private  val userRepository: UserRepository,
    private  val generalLojic: GeneralLojic
) {
    @GetMapping
    fun index(model: Model): String {
        val userForm = UserForm(userRepository.getAllUser())
        addAttribute(model, userForm, "");
        return "brgd0050_user"
    }

    private fun addAttribute(model: Model, userForm: UserForm, mode: String) {
        generalLojic.getPrefData()?.forEach{println(it)}
        model.addAttribute("userForm", userForm)
        model.addAttribute("sexData", generalLojic.getSexData())
        println( generalLojic.getSexData())
        model.addAttribute("prefData", generalLojic.getPrefData())
        model.addAttribute("cityData", generalLojic.getCityData())
    }
}