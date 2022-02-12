package jp.co.burgud.burgudaccount.common.entity

import java.time.LocalDateTime

data class Facility(
    val facilityKbn: String,
    val facilityName: String,
    val createUser: String?,
    val createDateTime: LocalDateTime?,
    val updateUser: String?,
    val updateDateTime: LocalDateTime?
)
