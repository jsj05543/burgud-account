package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.app.domain.entity.Certification
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
@AllArgsConstructor
data class CertificationRecord(
    val userCd: String,
    val authorityKbn: String,
    val password1: String,
    val password2: String?,
    val loginTime: LocalDateTime?,
    val logoutTime: LocalDateTime?,
    val createUser: String?,
    val createDateTime: LocalDateTime?,
    val updateUser: String?,
    val updateDateTime: LocalDateTime?
)

internal fun CertificationRecord.toEntity(): Certification =
    Certification(
        userCd = userCd,
        authorityKbn = authorityKbn,
        password1 = password1,
        password2 = password2,
        loginTime = loginTime,
        logoutTime = logoutTime,
        createUser = createUser,
        createDateTime = createDateTime,
        updateUser = updateUser,
        updateDateTime = updateDateTime
    )
