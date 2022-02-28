package jp.co.burgud.burgudaccount.app.domain.usecase

import jp.co.burgud.burgudaccount.app.domain.entity.LoginSession
import jp.co.burgud.burgudaccount.app.domain.entity.Sex
import jp.co.burgud.burgudaccount.app.domain.repository.SystemRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.InetAddress
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.servlet.http.HttpServletRequest

@Component
class SystemUseCase(
    @Value("\${system.name}")
    private val systemName: String,

    @Value("\${system.version}")
    private val systemVersion: String,

    private val systemRepository: SystemRepository
) {
    companion object {
        private const val BROWSER_UNKNOWN: String = "不明"

        private const val BROWSER_IE: String = "IE"

        private const val BROWSER_FIREFOX: String = "Firefox"

        private const val BROWSER_OPERA: String = "Opera"

        private const val BROWSER_CHROME: String = "Chrome"

        private const val BROWSER_SAFARI: String = "Safari"

        private const val BROWSER_NETSCAPE: String = "Netscape"
    }

    fun getSystemName(): String = systemName

    fun getSystemVersion(): String = systemVersion

    fun getHostName(): String {
        try {
            val osName = System.getProperty("os.name").lowercase(Locale.getDefault())
            val hostName = InetAddress.getLocalHost().hostName
            return osName + hostName
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "UnknownHost"
    }

    fun getHostAddress(): String {
        try {
            return InetAddress.getLocalHost().hostAddress
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "UnknownHost"
    }

    fun getUnAccess(): Boolean {
        return try {
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun getBrowser(request: HttpServletRequest): String {
        val sUserAgent = request.getHeader("user-agent")
        if (isIE(sUserAgent)) {
            return BROWSER_IE
        }
        if (isFirefox(sUserAgent)) {
            return BROWSER_FIREFOX
        }
        if (isOpera(sUserAgent)) {
            return BROWSER_OPERA
        }
        if (isChrome(sUserAgent)) {
            return BROWSER_CHROME
        }
        if (isSafari(sUserAgent)) {
            return BROWSER_SAFARI
        }
        return if (isNetscape(sUserAgent)) {
            BROWSER_NETSCAPE
        } else BROWSER_UNKNOWN
    }

    fun isIE(sUserAgent: String?): Boolean {
        val pattern: Pattern = Pattern.compile(".*((MSIE)+ [0-9]\\.[0-9]).*")
        val matcher: Matcher = pattern.matcher(sUserAgent)
        return matcher.matches()
    }

    fun isFirefox(sUserAgent: String?): Boolean {
        val pattern: Pattern = Pattern.compile(".*((Firefox/)+[0-9]\\.[0-9]\\.?[0-9]?).*")
        val matcher: Matcher = pattern.matcher(sUserAgent)
        return matcher.matches()
    }

    fun isOpera(sUserAgent: String?): Boolean {
        val pattern: Pattern = Pattern.compile(".*((Opera)+/? ?[0-9]\\.[0-9][0-9]?).*")
        val matcher: Matcher = pattern.matcher(sUserAgent)
        return matcher.matches()
    }

    fun isChrome(sUserAgent: String?): Boolean {
        val pattern: Pattern = Pattern.compile(".*((Chrome)+/?[0-9]\\.?[0-9]?).*")
        val matcher: Matcher = pattern.matcher(sUserAgent)
        return matcher.matches()
    }

    fun isSafari(sUserAgent: String?): Boolean {
        val pattern: Pattern = Pattern.compile(".*((Version/)+[0-9]\\.?[0-9]?\\.?[0-9]? Safari).*")
        val matcher: Matcher = pattern.matcher(sUserAgent)
        return matcher.matches()
    }

    fun isNetscape(sUserAgent: String?): Boolean {
        val pattern: Pattern = Pattern.compile(".*((Netscape)+[0-9]\\.[0-9][0-9]?).*")
        val matcher: Matcher = pattern.matcher(sUserAgent)
        return matcher.matches()
    }

    fun getSexData(): Map<String, String> {
        return Sex.asMap()
    }

    fun loginCheck(email: String, password: String): String? {
        return systemRepository.loginCheck(email, password)
    }

    fun createSession(loginSession: LoginSession): LoginSession {
        return systemRepository.createSession(loginSession)
    }

    fun findSession(sid: String): LoginSession? {
        return systemRepository.findSession(sid)
    }

    fun deleteSession(sid: String) {
        systemRepository.deleteSession(sid)
    }


}