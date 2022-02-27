package jp.co.burgud.burgudaccount.app.domain.entity

import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class Authority(
    var authorityKbn: String = "",
    var authorityName: String = "",
    var createUser: String = "",
    var createAt: LocalDateTime = LocalDateTime.now(),
    var updateUser: String? = null,
    var updateAt: LocalDateTime? = null
)
