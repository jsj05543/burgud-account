package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.FacilityUseCase
import jp.co.burgud.burgudaccount.app.domain.usecase.SystemUseCase
import jp.co.burgud.burgudaccount.app.web.form.FacilityEditForm
import jp.co.burgud.burgudaccount.app.web.form.FacilityForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("facility")
class FacilityController(
    private val facilityRepository: FacilityRepository,
    private val facilityUseCase: FacilityUseCase,
    private val systemUseCase: SystemUseCase,
    private val userRepository: UserRepository
) {
    @GetMapping
    fun index(
        model: Model,
        @CookieValue(value = "id", required = false) sid: String?,
    ): String {
        sid ?: return "redirect:/login"
        val loginSession = systemUseCase.findSession(sid) ?: return "redirect:/login"
        val loginUser = userRepository.getUserName(loginSession.userCd)
        model.addAttribute("userName", loginUser)

        val form = FacilityEditForm(
            facilityList = facilityRepository.getAllFacility()
        )
        model.addAttribute("form", form)
        return "brgd0070_facility"
    }

    @PostMapping(params = ["cancel"])
    fun cancel(
        model: Model,
        @CookieValue(value = "id", required = false) sid: String?,
    ): String {
        sid ?: return "redirect:/login"
        return index(model, sid)
    }

    @PostMapping(params = ["update"])
    fun updateFacility(
        model: Model,
        @Validated form: FacilityEditForm,
        @CookieValue(value = "id", required = false) sid: String?,
        result: BindingResult
    ): String {
        sid ?: return "redirect:/login"
        val loginSession = systemUseCase.findSession(sid) ?: return "redirect:/login"
        val loginUser = userRepository.getUserName(loginSession.userCd)
        model.addAttribute("form", form)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            model.addAttribute("mode", "update")
            return "brgd0070_facility"
        }
        facilityUseCase.update(form.facilityList, loginUser = loginUser)
        model.addAttribute("success", true)
        return index(model, sid)
    }

    @GetMapping("new")
    fun newFacility(
        model: Model,
        @CookieValue(value = "id", required = false) sid: String?,
    ): String {
        sid ?: return "redirect:/login"
        val loginSession = systemUseCase.findSession(sid) ?: return "redirect:/login"
        val loginUser = userRepository.getUserName(loginSession.userCd)
        model.addAttribute("userName", loginUser)
        val form = FacilityForm(
            facilityKbn = facilityUseCase.createNewCountryKbn(),
            facilityName = null
        )
        model.addAttribute("form", form)
        return "brgd0071_facility.html"
    }

    @PostMapping(params = ["insert"])
    fun createFacility(
        model: Model,
        @Validated form: FacilityForm,
        @CookieValue(value = "id", required = false) sid: String?,
        result: BindingResult
    ): String {
        sid ?: return "redirect:/login"
        val loginSession = systemUseCase.findSession(sid) ?: return "redirect:/login"
        val loginUser = userRepository.getUserName(loginSession.userCd)
        model.addAttribute("userName", loginUser)
        model.addAttribute("form", form)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            return "brgd0071_facility"
        }

        facilityUseCase.create(
            facilityKbn = form.facilityKbn,
            facilityName = form.facilityName,
            loginUser = loginUser
        )
        model.addAttribute("success", true)
        return index(model, sid)
    }
}