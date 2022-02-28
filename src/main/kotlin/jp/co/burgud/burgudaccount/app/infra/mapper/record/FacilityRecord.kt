package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.app.domain.entity.Facility
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class FacilityRecord(
    val id: Int = -1,
    val facilityKbn: String,
    val facilityName: String,
    val createUser: String,
    val createAt: LocalDateTime,
    val updateUser: String?,
    val updateAt: LocalDateTime?
)
internal fun FacilityRecord.toEntity(): Facility =
    Facility(
        facilityKbn = facilityKbn,
        facilityName = facilityName,
        createUser = createUser,
        createAt = createAt,
        updateUser = updateUser,
        updateAt= updateAt
    )

