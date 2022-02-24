package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.app.domain.entity.Facility
import java.time.LocalDateTime

internal data class FacilityRecord(
    val id: Int = -1,
    val facilityKbn: String,
    val facilityName: String,
    val createUser: String?,
    val createDateTime: LocalDateTime?,
    val updateUser: String?,
    val updateDateTime: LocalDateTime?
)
internal fun FacilityRecord.toEntity(): Facility =
    Facility(
        facilityKbn = facilityKbn,
        facilityName = facilityName,
        createUser = createUser,
        createDateTime = createDateTime,
        updateUser = updateUser,
        updateDateTime= updateDateTime
    )

