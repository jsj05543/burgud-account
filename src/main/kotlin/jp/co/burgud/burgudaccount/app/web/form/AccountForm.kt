package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.app.domain.entity.Account
import lombok.NoArgsConstructor

@NoArgsConstructor
data class AccountForm(
    val accountList: List<Account>
)