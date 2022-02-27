package jp.co.burgud.burgudaccount.app.domain.service

import jp.co.burgud.burgudaccount.app.domain.entity.Account
import jp.co.burgud.burgudaccount.app.domain.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {
    fun getAccountCdList(): List<String> {
        return accountRepository.getAccountCdList()
    }

    fun getAllAccount(): List<Account> {
        return accountRepository.getAllAccount()
    }

    fun searchAccount(countryKbn: String, keyword: String): List<Account> {
        return accountRepository.findAccountListByCountryKbnAndKeyword(countryKbn, keyword)
    }

    fun getOneAccount(accountCd: String): Account {
        return accountRepository.getOneAccount(accountCd)
    }

    fun update(account: Account) {
        accountRepository.update(account)
    }

    fun create(account: Account) {
        accountRepository.create(account)
    }
}