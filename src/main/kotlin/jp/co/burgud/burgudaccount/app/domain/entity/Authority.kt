package jp.co.burgud.burgudaccount.app.domain.entity

import java.time.LocalDateTime

data class Authority(
    val authorityKbn: String,
    val authorityName: String,
    val createUser: String?,
    val createDateTime: LocalDateTime?,
    val updateUser: String?,
    val updateDateTime: LocalDateTime?
)
