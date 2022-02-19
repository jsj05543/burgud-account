package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.common.entity.Account
import jp.co.burgud.burgudaccount.common.entity.Authority
import jp.co.burgud.burgudaccount.common.entity.Country

interface AccountRepository {
    fun getAllAccount(): List<Account>
}