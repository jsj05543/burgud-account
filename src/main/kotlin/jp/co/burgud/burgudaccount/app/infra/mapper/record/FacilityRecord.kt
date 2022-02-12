package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.common.entity.Country
import jp.co.burgud.burgudaccount.common.entity.Facility
import java.time.LocalDateTime

internal data class FacilityRecord(
    val id: Int,
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

