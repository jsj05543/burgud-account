package jp.co.burgud.burgudaccount.app.domain.usecase

import jp.co.burgud.burgudaccount.app.domain.entity.Account
import jp.co.burgud.burgudaccount.app.domain.repository.AccountRepository
import jp.co.burgud.burgudaccount.app.domain.service.AccountService
import jp.co.burgud.burgudaccount.app.domain.service.CreateKbnService
import org.springframework.stereotype.Component

@Component
class AccountUseCase(
    private val accountService: AccountService,
    private val createKbnService: CreateKbnService,
    private val accountRepository: AccountRepository
) {
    companion object {
        private const val ACCOUNT_CODE = "ACCOUNT"
        private const val ACCOUNT_KBN_NEW = "AT00"
    }

    fun createNewAccountCd(): String {
        val accountCdList = accountService.getAccountCdList()
        if (accountCdList.isEmpty()) {
            return ACCOUNT_KBN_NEW
        }
        return createKbnService.getCodeVal(ACCOUNT_CODE) + createKbnService.getMaxKbn(accountCdList)
    }

    fun getAllAccount(): List<Account> {
        return accountService.getAllAccount()
    }

    fun searchAccount(countryKbn: String, keyword: String): List<Account> {
        return accountService.searchAccount(countryKbn, keyword)
    }

    fun getOneAccount(accountCd: String): Account {
        return accountService.getOneAccount(accountCd)
    }

    fun getQuestionData(): Map<Int, String>  {
        return accountRepository.getAllQuestion().map {
            it.first to it.second
        }.toMap()

    }

    fun getAnswerData(): Map<Int, String>  {
        return accountRepository.getAllAnswer().map {
            it.first to it.second
        }.toMap()
    }
}