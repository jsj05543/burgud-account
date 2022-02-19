package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.common.entity.Country
import jp.co.burgud.burgudaccount.common.entity.Facility
import jp.co.burgud.burgudaccount.common.entity.User
import lombok.NoArgsConstructor

@NoArgsConstructor
data class UserForm(
    val userList: List<User>
)