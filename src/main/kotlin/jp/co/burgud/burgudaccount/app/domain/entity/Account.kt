package jp.co.burgud.burgudaccount.app.domain.entity

import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class Account(
    val accountCd: String,
    val accountUsedName: String,
    val usedDetail: String?,
    val accountName: String,
    val accountPassword: String,
    val countryKbn: String,
    val facilityKbn: String,
    val query1: String?,
    val answer1: String?,
    val query2: String?,
    val answer2: String?,
    val query3: String?,
    val answer3: String?,
    val oldPassword1: String?,
    val oldPassword2: String?,
    val oldPassword3: String?,
    val biko: String?,
    val createUser: String,
    val createDateTime: LocalDateTime,
    val updateUser: String?,
    val updateDateTime: LocalDateTime?
)
