package jp.co.burgud.burgudaccount.app.domain.usecase

import jp.co.burgud.burgudaccount.app.domain.service.AccountService
import jp.co.burgud.burgudaccount.app.domain.service.CreateKbnService
import jp.co.burgud.burgudaccount.app.domain.service.UserService
import org.springframework.stereotype.Component

@Component
class AccountUseCase(
    private val accountService: AccountService,
    private val createKbnService: CreateKbnService
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
}