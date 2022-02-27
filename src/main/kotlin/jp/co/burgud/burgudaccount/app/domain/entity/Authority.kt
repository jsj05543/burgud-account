package jp.co.burgud.burgudaccount.app.domain.entity

import java.time.LocalDateTime

data class Authority(
    var authorityKbn: String = "",
    var authorityName: String = "",
    var createUser: String? = null,
    var createDateTime: LocalDateTime? = null,
    var updateUser: String? = null,
    var updateDateTime: LocalDateTime? = null
)
