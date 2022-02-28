package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.app.domain.entity.Authority
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class AuthorityRecord(
    val id: Int = -1,
    val authorityKbn: String,
    val authorityName: String,
    val createUser: String,
    val createAt: LocalDateTime,
    val updateUser: String?,
    val updateAt: LocalDateTime?
)
internal fun AuthorityRecord.toEntity(): Authority =
    Authority(
        authorityKbn = authorityKbn,
        authorityName = authorityName,
        createUser = createUser,
        createAt = createAt,
        updateUser = updateUser,
        updateAt= updateAt
    )

