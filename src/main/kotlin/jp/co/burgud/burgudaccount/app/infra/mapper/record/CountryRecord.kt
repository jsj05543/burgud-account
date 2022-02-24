package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.app.domain.entity.Country
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class CountryRecord(
    val id: Int = -1,
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

