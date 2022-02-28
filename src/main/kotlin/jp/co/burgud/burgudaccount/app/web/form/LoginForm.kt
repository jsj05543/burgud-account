package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.app.domain.entity.Account
import lombok.NoArgsConstructor

@NoArgsConstructor
data class LoginForm(
    val email: String,
    val password: String
)