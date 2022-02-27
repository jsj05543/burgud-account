package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.FacilityUseCase
import jp.co.burgud.burgudaccount.app.web.form.FacilityEditForm
import jp.co.burgud.burgudaccount.app.web.form.FacilityForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("facility")
class FacilityController(
    private val facilityRepository: FacilityRepository,
    private val facilityUseCase: FacilityUseCase
) {
    @GetMapping
    fun index(model: Model): String {
        val form = FacilityEditForm(
            facilityList = facilityRepository.getAllFacility()
        )
        model.addAttribute("form", form)
        return "brgd0070_facility"
    }

    @PostMapping(params = ["cancel"])
    fun cancel(model: Model): String {
        return index(model)
    }

    @PostMapping(params = ["update"])
    fun updateFacility(model: Model, @Validated form: FacilityEditForm, result: BindingResult): String? {
        model.addAttribute("form", form)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            model.addAttribute("mode", "update")
            return "brgd0070_facility"
        }
        facilityUseCase.update(form.facilityList, loginUser = "hakuei_up")
        model.addAttribute("success", true)
        return index(model)
    }

    @GetMapping("new")
    fun newFacility(model: Model): String {
        val form = FacilityForm(
            facilityKbn = facilityUseCase.createNewCountryKbn(),
            facilityName = null
        )
        model.addAttribute("form", form)
        return "brgd0071_facility.html"
    }

    @PostMapping(params = ["insert"])
    fun createFacility(model: Model, @Validated form: FacilityForm, result: BindingResult): String {
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
            loginUser = "hakuei_create"
        )
        model.addAttribute("success", true)
        return index(model)
    }
}