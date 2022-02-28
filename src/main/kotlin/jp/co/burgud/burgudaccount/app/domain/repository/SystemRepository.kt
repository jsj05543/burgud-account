package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.app.domain.entity.LoginSession

interface SystemRepository {
    fun getPageCount(): Int

    fun updatePageCount(count: Int)

    fun getCodeVal(code: String): String

    fun loginCheck(email: String, password: String): String?

    fun createSession(loginSession: LoginSession): LoginSession

    fun findSession(sid: String): LoginSession?

    fun deleteSession(sessionId: String)
}