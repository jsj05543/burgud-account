package jp.co.burgud.burgudaccount.app.domain.entity

import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class Certification(
    val userCd: String,
    val authorityKbn: String,
    val passwordNow: String,
    val passwordBefore: String?,
    val loginTime: LocalDateTime?,
    val logoutTime: LocalDateTime?,
    val createUser: String,
    val createAt: LocalDateTime,
    val updateUser: String?,
    val updateAt: LocalDateTime?
)
