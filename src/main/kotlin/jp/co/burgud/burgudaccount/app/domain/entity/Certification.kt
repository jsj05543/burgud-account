package jp.co.burgud.burgudaccount.app.domain.entity

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
@AllArgsConstructor
data class Certification(
    val userCd: String,
    val authorityKbn: String,
    val passwordNow: String,
    val passwordBefore: String?,
    val loginTime: LocalDateTime?,
    val logoutTime: LocalDateTime?,
    val createUser: String?,
    val createDateTime: LocalDateTime?,
    val updateUser: String?,
    val updateDateTime: LocalDateTime?
)
