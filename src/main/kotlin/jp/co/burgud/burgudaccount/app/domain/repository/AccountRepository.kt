package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Account

interface AccountRepository {
    fun getAllAccount(): List<Account>
}