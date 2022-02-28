package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.CountryUseCase
import jp.co.burgud.burgudaccount.app.web.form.CountryEditForm
import jp.co.burgud.burgudaccount.app.web.form.CountryForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("country")
class CountryController(
    private val countryRepository: CountryRepository,
    private val countryUseCase: CountryUseCase
) {
    @GetMapping
    fun index(
        model: Model,
        @CookieValue(value = "id", required = false) sid: String?,
    ): String {
        sid ?: return "redirect:/login"
        val form = CountryEditForm(
            countryList = countryRepository.getAllCountry()
        )
        model.addAttribute("form", form)
        return "brgd0060_country"
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
    fun updateContry(
        model: Model,
        @Validated form: CountryEditForm,
        @CookieValue(value = "id", required = false) sid: String?,
        result: BindingResult
    ): String {
        sid ?: return "redirect:/login"
        model.addAttribute("form", form)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            model.addAttribute("mode", "update")
            return "brgd0060_country"
        }
        countryUseCase.updateCountry(form.countryList, loginUser = "hakuei_update")
        model.addAttribute("success", true)
        return index(model, sid)
    }

    @GetMapping("new")
    fun newCountry(
        model: Model,
        @CookieValue(value = "id", required = false) sid: String?,
    ): String {
        sid ?: return "redirect:/login"
        val form = CountryForm(
            countryKbn = countryUseCase.createNewCountryKbn(),
            countryName = null
        )
        model.addAttribute("form", form)
        return "brgd0061_country.html"
    }

    @PostMapping(params = ["insert"])
    fun createCountry(
        model: Model,
        @Validated form: CountryForm,
        @CookieValue(value = "id", required = false) sid: String?,
        result: BindingResult
    ): String {
        sid ?: return "redirect:/login"
        model.addAttribute("form", form)
        if (result.hasErrors()) {
            val errorList = result.allErrors
            val isError = if (errorList.size > 0) true else false
            model.addAttribute("isError", isError)
            model.addAttribute("errorList", errorList)
            return "brgd0061_country"
        }
        countryUseCase.create(
            countryKbn = form.countryKbn,
            countryName = form.countryName,
            loginUser = "hakuei_create"
        )
        model.addAttribute("success", true)
        return index(model, sid)
    }
}