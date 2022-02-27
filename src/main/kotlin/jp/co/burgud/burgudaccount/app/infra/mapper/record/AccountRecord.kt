package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.app.domain.entity.Account
import java.time.LocalDateTime

internal data class AccountRecord(
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
    val createAt: LocalDateTime,
    val updateUser: String?,
    val updateAt: LocalDateTime?
)

internal fun AccountRecord.toEntity(): Account =
    Account(
        accountCd = accountCd,
        accountUsedName = accountUsedName,
        usedDetail = usedDetail,
        accountName = accountName,
        accountPassword = accountPassword,
        countryKbn = countryKbn,
        facilityKbn = facilityKbn,
        query1 = query1,
        answer1 = answer1,
        query2 = query2,
        answer2 = answer2,
        query3 = query3,
        answer3 = answer3,
        oldPassword1 = oldPassword1,
        oldPassword2 = oldPassword2,
        oldPassword3 = oldPassword3,
        biko = biko,
        createUser = createUser,
        createAt = createAt,
        updateUser = updateUser,
        updateAt = updateAt
    )