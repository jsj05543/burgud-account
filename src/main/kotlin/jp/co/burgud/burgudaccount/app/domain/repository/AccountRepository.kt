package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Account

interface AccountRepository {
    fun getAllAccount(): List<Account>

    fun getAccountCdList(): List<String>

    fun findAccountListByCountryKbnAndKeyword(countryKbn: String?, keyword: String?): List<Account>

    fun getOneAccount(accountCd: String): Account

    fun getAllQuestion(): List<Pair<Int, String>>

    fun getAllAnswer(): List<Pair<Int, String>>

    fun update(account: Account, oldAccount: Account, loginUser: String)

    fun create(account: Account)

    fun delete(accountCd: String)
}