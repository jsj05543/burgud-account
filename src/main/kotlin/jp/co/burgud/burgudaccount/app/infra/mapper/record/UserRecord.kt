package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.common.entity.User
import java.time.LocalDateTime

internal data class UserRecord(
    val userCd: String,
    val email: String,
    val fullName: String,
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

internal fun UserRecord.toEntity(): User =
    User(
        userCd = userCd,
        email = email,
        firstName = firstName,
        lastName = lastName,
        sex = sex,
        birth = birth,
        tel = tel,
        zip = zip,
        address = address,
        nutagPref = nutagPref,
        nutagCity = nutagCity,
        sendMailFlg = sendMailFlg,
        createUser = createUser,
        createDateTime = createDateTime,
        updateUser = updateUser,
        updateDateTime = updateDateTime
    )