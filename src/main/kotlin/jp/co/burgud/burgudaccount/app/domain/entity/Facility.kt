package jp.co.burgud.burgudaccount.app.domain.entity

import java.time.LocalDateTime

data class Facility(
    var facilityKbn: String = "",
    var facilityName: String = "",
    var createUser: String? =null,
    var createDateTime: LocalDateTime?=null,
    var updateUser: String? = null,
    var updateDateTime: LocalDateTime? = null
)
