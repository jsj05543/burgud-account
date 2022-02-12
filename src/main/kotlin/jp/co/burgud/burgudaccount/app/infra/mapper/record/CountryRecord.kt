package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.common.entity.Country
import java.time.LocalDateTime

internal data class CountryRecord(
    val id: Int,
    val countryKbn: String,
    val countryName: String,
    val createUser: String?,
    val createDateTime: LocalDateTime?,
    val updateUser: String?,
    val updateDateTime: LocalDateTime?
)
internal fun CountryRecord.toEntity(): Country =
    Country(
        countryKbn = countryKbn,
        countryName =countryName,
        createUser = createUser,
        createDateTime = createDateTime,
        updateUser = updateUser,
        updateDateTime= updateDateTime
    )

