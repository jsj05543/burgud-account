package jp.co.burgud.burgudaccount.app.domain.entity

import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class Country(
    var countryKbn: String = "",
    var countryName: String = "",
    var createUser: String = "",
    var createDateTime: LocalDateTime = LocalDateTime.now(),
    var updateUser: String? = null,
    var updateDateTime: LocalDateTime? = null
)
