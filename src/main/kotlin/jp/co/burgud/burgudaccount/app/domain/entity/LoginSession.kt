package jp.co.burgud.burgudaccount.app.domain.entity

import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class LoginSession(
    val userCd: String,
    val sessionId: String,
    val loginAt: LocalDateTime?,
    val logoutAt: LocalDateTime?
)
