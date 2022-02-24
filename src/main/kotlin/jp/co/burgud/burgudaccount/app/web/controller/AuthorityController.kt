package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.AuthorityUseCase
import jp.co.burgud.burgudaccount.app.web.form.AuthorityForm
import jp.co.burgud.burgudaccount.app.domain.entity.Authority
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("authority")
class AuthorityController(
    private val authorityRepository: AuthorityRepository,
    private val authorityUseCase: AuthorityUseCase

) {
    @GetMapping
    private fun index(model: Model): String {
        val form = AuthorityForm(authorityRepository.getAllAuthority())
        model.addAttribute("form", form)
        return "brgd0080_authority"
    }

    @GetMapping("new")
    fun newAurhority(model: Model): String {
        val authority = Authority(authorityUseCase.createNewAuthorityKbn(), "")
        model.addAttribute("form", authority)
        return "brgd0081_authority.html"
    }
}