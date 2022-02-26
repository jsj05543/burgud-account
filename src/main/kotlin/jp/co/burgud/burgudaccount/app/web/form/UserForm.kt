package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.app.domain.entity.User
import lombok.NoArgsConstructor

@NoArgsConstructor
data class UserForm(
    val userList: List<User>
)