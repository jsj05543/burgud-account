package jp.co.burgud.burgudaccount.app.domain.entity

import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
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
    val createUser: String,
    val createAt: LocalDateTime,
    val updateUser: String?,
    val updateAt: LocalDateTime?
)
