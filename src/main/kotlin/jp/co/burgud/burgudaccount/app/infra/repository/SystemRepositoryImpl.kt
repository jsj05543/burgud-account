package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.entity.LoginSession
import jp.co.burgud.burgudaccount.app.domain.repository.SystemRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.SystemMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.LoginSessionRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import org.springframework.stereotype.Repository

@Repository
internal class SystemRepositoryImpl(
    private val systemMapper: SystemMapper
) : SystemRepository {
    override fun getPageCount(): Int {
        return systemMapper.find()
    }

    override fun updatePageCount(count: Int) {
        systemMapper.update(count)
    }

    override fun getCodeVal(code: String): String {
        return systemMapper.findCodeValByCode(code)
    }

    override fun loginCheck(email: String, password: String): String? {
        return systemMapper.findLoginUserCd(email, password)
    }

    override fun createSession(loginSession: LoginSession): LoginSession {
        val record = LoginSessionRecord(
            userCd = loginSession.userCd,
            sessionId = loginSession.sessionId,
            loginAt = loginSession.loginAt,
            logoutAt = loginSession.logoutAt
        )
        systemMapper.insertSession(record)
        return record.toEntity()
    }

    override fun findSession(sid: String): LoginSession? {
        return systemMapper.findSession(sid)?.toEntity()
    }

    override fun deleteSession(sessionId: String) {
        systemMapper.deleteSession(sessionId)
    }

}