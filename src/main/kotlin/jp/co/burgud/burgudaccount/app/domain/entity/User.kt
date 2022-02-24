package jp.co.burgud.burgudaccount.app.domain.entity

import java.time.LocalDateTime

data class User(
    val userCd: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val sex: String,
    val birth: String,
    val tel: String,
    val zip: String,
    val address: String,
    val nutagPref: String,
    val nutagCity: String,
    val sendMailFlg: String?,
    val createUser: String?,
    val createDateTime: LocalDateTime?,
    val updateUser: String?,
    val updateDateTime: LocalDateTime?
)
