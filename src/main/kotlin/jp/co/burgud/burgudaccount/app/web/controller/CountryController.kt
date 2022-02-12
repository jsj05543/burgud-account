package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.web.form.CountryForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("country")
class CountryController(
    private  val countryRepository: CountryRepository
) {
    @GetMapping
    private fun index(model: Model): String {
        val form = CountryForm(countryRepository.getAllCountry())
        println("~~~~~~~~~~~~~~~~~~~~~~~~")
      //  form.forEach{println(it)}
        model.addAttribute("form", form)
        return "brgd0060_country"
    }
}