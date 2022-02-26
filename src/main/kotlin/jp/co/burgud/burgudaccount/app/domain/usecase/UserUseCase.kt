package jp.co.burgud.burgudaccount.app.domain.usecase

import jp.co.burgud.burgudaccount.app.domain.service.CreateKbnService
import jp.co.burgud.burgudaccount.app.domain.service.UserService
import org.springframework.stereotype.Component

@Component
class UserUseCase(
    private val userService: UserService,
    private val createKbnService: CreateKbnService
) {
    companion object {
        private const val USER_CODE = "USER"
        private const val USER_KBN_NEW = "BU00"
    }

    fun createNewUserCd(): String {
        val userCdList = userService.getUserCdList()
        if (userCdList.isEmpty()) {
            return USER_KBN_NEW
        }
        return createKbnService.getCodeVal(USER_CODE) + createKbnService.getMaxKbn(userCdList)
    }
}