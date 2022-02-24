package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.entity.Facility
import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.FacilityUseCase
import jp.co.burgud.burgudaccount.app.web.form.FacilityForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDateTime


@Controller
@RequestMapping("facility")
class FacilityController(
    private val facilityRepository: FacilityRepository,
    private val facilityUseCase: FacilityUseCase
) {
    @GetMapping
    private fun index(model: Model): String {
        val form = FacilityForm(facilityRepository.getAllFacility())
        model.addAttribute("form", form)
        return "brgd0070_facility"
    }

    @GetMapping("new")
    fun newCountry(model: Model): String {
        val facility = Facility(facilityUseCase.createNewCountryKbn(), "", "", LocalDateTime.MAX, "", LocalDateTime.MAX)
        model.addAttribute("form", facility)
        return "brgd0071_facility.html";
    }
}