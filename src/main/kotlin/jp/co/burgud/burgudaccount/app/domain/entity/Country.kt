package jp.co.burgud.burgudaccount.app.domain.entity

import java.time.LocalDateTime

data class Country(
    var countryKbn: String = "",
    var countryName: String = "",
    var createUser: String? = null,
    var createDateTime: LocalDateTime? = null,
    var updateUser: String? = null,
    var updateDateTime: LocalDateTime? = null
)
