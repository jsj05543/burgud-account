package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.web.form.CountryForm
import jp.co.burgud.burgudaccount.app.web.form.FacilityForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("facility")
class FacilityController(
    private  val facilityRepository: FacilityRepository
) {
    @GetMapping
    private fun index(model: Model): String {
        val form = FacilityForm(facilityRepository.getAllFacility())
        model.addAttribute("form", form)
        return "brgd0070_facility"
    }
}