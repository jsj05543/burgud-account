package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.app.domain.entity.LoginSession
import jp.co.burgud.burgudaccount.app.domain.entity.User
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class LoginSessionRecord(
    val userCd: String,
    val sessionId: String,
    val loginAt: LocalDateTime?,
    val logoutAt: LocalDateTime?,
)

fun LoginSessionRecord.toEntity(): LoginSession =
    LoginSession(
        userCd = this.userCd,
        sessionId = this.sessionId,
        loginAt = this.loginAt,
        logoutAt = this.logoutAt
    )
