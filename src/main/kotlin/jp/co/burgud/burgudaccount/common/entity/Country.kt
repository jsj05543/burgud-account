package jp.co.burgud.burgudaccount.common.entity

import java.time.LocalDateTime

data class Country(
    val countryKbn: String,
    val countryName: String,
    val createUser: String?,
    val createDateTime: LocalDateTime?,
    val updateUser: String?,
    val updateDateTime: LocalDateTime?
)
