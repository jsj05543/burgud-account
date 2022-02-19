package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.repository.SystemRepository
import jp.co.burgud.burgudaccount.app.web.form.SystemForm
import jp.co.burgud.burgudaccount.common.util.SystemManager
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest


@Controller
@RequestMapping
class SystemController(
    private val systemManager: SystemManager,
    private val systemRepository: SystemRepository
) {

    @GetMapping("/")
    fun index(model: Model, @ModelAttribute("form") systemForm: SystemForm?, request: HttpServletRequest): String? {

        val newCount = systemRepository.getPageCount() + 1
        val systemForm = SystemForm(
            systemName = systemManager.getSystemName(),
            systemVersion = systemManager.getSystemVersion(),
            hostName = systemManager.getHostName(),
            browser = systemManager.getBrowser(request),
            iPAddress = systemManager.getHostAddress(),
            pageCount = newCount,
            unAccess = systemManager.getUnAccess()
        )
        model.addAttribute("systemForm", systemForm)
        systemRepository.updatePageCount(newCount)
        return "brgd0040_system.html"
    }

    @GetMapping("/theme")
    fun theme(): String = "brgd0110_theme.html"

    @GetMapping("/logo")
    fun password(): String = "brgd0120_logo.html"

    @GetMapping("/login")
    fun login(): String = "login.html"
}