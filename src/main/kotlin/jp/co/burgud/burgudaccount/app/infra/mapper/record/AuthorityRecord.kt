package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.app.domain.entity.Authority
import java.time.LocalDateTime

internal data class AuthorityRecord(
    val id: Int = -1,
    val authorityKbn: String,
    val authorityName: String,
    val createUser: String?,
    val createDateTime: LocalDateTime?,
    val updateUser: String?,
    val updateDateTime: LocalDateTime?
)
internal fun AuthorityRecord.toEntity(): Authority =
    Authority(
        authorityKbn = authorityKbn,
        authorityName = authorityName,
        createUser = createUser,
        createDateTime = createDateTime,
        updateUser = updateUser,
        updateDateTime= updateDateTime
    )

