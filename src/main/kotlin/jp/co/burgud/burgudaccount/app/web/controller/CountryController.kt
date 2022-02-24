package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.entity.Country
import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.CountryUseCase
import jp.co.burgud.burgudaccount.app.web.form.CountryForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDateTime


@Controller
@RequestMapping("country")
class CountryController(
    private val countryRepository: CountryRepository,
    private val countryUseCase: CountryUseCase
) {
    @GetMapping
    private fun index(model: Model): String {
        val form = CountryForm(countryRepository.getAllCountry())
        model.addAttribute("form", form)
        return "brgd0060_country"
    }

    @GetMapping("new")
    fun newCountry(model: Model): String {
        val country = Country(countryUseCase.createNewCountryKbn(), "", "", LocalDateTime.MAX, "", LocalDateTime.MAX)
        model.addAttribute("form", country)
        return "brgd0061_country.html"
    }

    @PostMapping(params = ["update"])
    fun updateContry(model: Model, form: CountryForm, result: BindingResult): String {
        model.addAttribute("form", form)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            model.addAttribute("mode", "update")
            return "brgd0060_country"
        }
        //countryRepository.update(form.countryList)
        model.addAttribute("success", true)
        return index(model)
    }

    @PostMapping(params = ["insert"])
    fun createCountry(model: Model, @Validated country: Country, result: BindingResult): String {
        model.addAttribute("form", country)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            return "brgd0061_country"
        }
        countryRepository.create(country)
        model.addAttribute("success", true)
        return index(model)
    }
}