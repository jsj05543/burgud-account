package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.entity.LoginSession
import jp.co.burgud.burgudaccount.app.domain.repository.SystemRepository
import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.domain.usecase.SystemUseCase
import jp.co.burgud.burgudaccount.app.web.form.LoginForm
import jp.co.burgud.burgudaccount.app.web.form.SystemForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Controller
@RequestMapping
class SystemController(
    private val systemUseCase: SystemUseCase,
    private val systemRepository: SystemRepository,
    private val userRepository: UserRepository
) {

    //　直接ホーム画面にアクセスすればログイン画面へ遷移
    @GetMapping("/")
    fun index(
        model: Model,
        request: HttpServletRequest,
        @CookieValue(value = "id", required = false) sid: String?
    ): String {
        sid ?: return login(model)
        val loginSession = systemUseCase.findSession(sid) ?: return login(model)
        return createMainPageForm(
            userCd = loginSession.userCd,
            request = request,
            logoutAt = loginSession.logoutAt,
            loginAt = loginSession.loginAt,
            model = model
        )
    }

    // ログイン画面からログイン
    @GetMapping("/login")
    fun login(model: Model): String {
        val loginForm = LoginForm(
            email = "",
            password = ""
        )
        model.addAttribute("form", loginForm)
        return "login"
    }

    // ログイン情報を認証成功すればセッションを作成してホーム画面へ遷移
    @PostMapping("/")
    fun index(
        model: Model,
        request: HttpServletRequest,
        response: HttpServletResponse,
        @ModelAttribute("form") @Validated form: LoginForm,
        @CookieValue(value = "id", required = false) sid: String?
    ): String {
        val userCd = systemUseCase.loginCheck(
            email = form.email,
            password = form.password
        )
        userCd ?: return login(model)
        val loginSession = if (sid == null) {
            createLoginSession(userCd, response)
        } else {
            systemUseCase.findSession(userCd)
        }
        return createMainPageForm(
            userCd = userCd,
            request = request,
            logoutAt = loginSession?.logoutAt,
            loginAt = loginSession?.loginAt,
            model = model
        )
    }

    // ログアウトすればセッションを廃棄し、ログイン画面へ遷移
    @GetMapping("/logout")
    fun logOut(
        model: Model,
        request: HttpServletRequest,
        response: HttpServletResponse,
        @CookieValue(value = "id", required = false) sid: String?
    ): String {
        sid ?: return login(model)
        deleteLoginSession(request, response, sid)
        return login(model)
    }

    private fun createLoginSession(
        userCd: String,
        response: HttpServletResponse
    ): LoginSession {
        val sessionId = UUID.randomUUID().toString()
        val loginSession = LoginSession(
            userCd = userCd,
            sessionId = sessionId,
            loginAt = LocalDateTime.now(),
            logoutAt = null
        )
        val cookie = Cookie("id", sessionId)
        //cookie.maxAge = (265 * 24 * 60 * 60)
        cookie.path = "/"
        response.addCookie(cookie)
        systemUseCase.createSession(loginSession)
        return loginSession
    }

    private fun createMainPageForm(
        userCd: String,
        request: HttpServletRequest,
        logoutAt: LocalDateTime?,
        loginAt: LocalDateTime?,
        model: Model
    ): String {
        val newCount = systemRepository.getPageCount() + 1
        val userName = userRepository.getUserName(userCd)
        val form = SystemForm(
            systemName = systemUseCase.getSystemName(),
            systemVersion = systemUseCase.getSystemVersion(),
            hostName = systemUseCase.getHostName(),
            browser = systemUseCase.getBrowser(request),
            iPAddress = systemUseCase.getHostAddress(),
            pageCount = newCount,
            unAccess = systemUseCase.getUnAccess(),
            userName = userName,
            logoutAt = logoutAt,
            loginAt = loginAt
        )
        model.addAttribute("form", form)
        systemRepository.updatePageCount(newCount)
        return "brgd0040_system.html"
    }

    private fun deleteLoginSession(
        request: HttpServletRequest,
        response: HttpServletResponse,
        sid: String
    ) {
        val cookies = request.cookies
        for (cookie in cookies) {
            if ("id" == cookie.name) {
                cookie.maxAge = 0
                cookie.path = "/"
                response.addCookie(cookie)
            }
        }
        systemUseCase.deleteSession(sid)
    }

    @GetMapping("/theme")
    fun theme(): String = "brgd0110_theme.html"
}