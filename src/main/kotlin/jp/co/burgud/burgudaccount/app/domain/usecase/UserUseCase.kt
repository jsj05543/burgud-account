package jp.co.burgud.burgudaccount.app.domain.usecase

import jp.co.burgud.burgudaccount.app.domain.entity.Certification
import jp.co.burgud.burgudaccount.app.domain.entity.User
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

    fun getAllUser(): List<User> {
        return userService.getAllUser()
    }

    fun getOneUser(userCd: String): User {
        return userService.getOneUser(userCd)
    }

    fun getOneUserCertification(userCd: String): Certification {
        return userService.getOneUserCertification(userCd)
    }

    fun create(user: User, authorityKbn: String, password: String) {
        userService.create(user, authorityKbn, password)
    }

    fun delete(userCd: String) {
        userService.delete(userCd)
    }

    fun update(user: User) {
        userService.update(user)
    }

    fun updatePassword(userCd: String, passwordNew: String?) {
        userService.updatePassword(userCd, passwordNew)
    }

    fun updateUserAuth(userCd: String, authorityKbn: String) {
        userService.updateUserAuth(userCd, authorityKbn)
    }


}