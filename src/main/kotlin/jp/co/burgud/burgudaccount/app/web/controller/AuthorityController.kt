package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.web.form.AuthorityForm
import jp.co.burgud.burgudaccount.app.web.form.CountryForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("authority")
class AuthorityController(
    private  val authorityRepository: AuthorityRepository
) {
    @GetMapping
    private fun index(model: Model): String {
        val form = AuthorityForm(authorityRepository.getAllAuthority())
        model.addAttribute("form", form)
        return "brgd0080_authority"
    }
}