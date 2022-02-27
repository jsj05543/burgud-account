package jp.co.burgud.burgudaccount.app.domain.service

import jp.co.burgud.burgudaccount.app.domain.entity.Certification
import jp.co.burgud.burgudaccount.app.domain.entity.User
import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getUserCdList(): List<String> {
        return userRepository.getUserCdList()
    }

    fun getAllUser(): List<User> {
        return userRepository.getAllUser()
    }

    fun getOneUser(userCd: String): User {
        return userRepository.getOneUser(userCd)
    }

    fun getOneUserCertification(userCd: String): Certification {
        return userRepository.getOneUserCertification(userCd)
    }

    fun delete(userCd: String) {
        userRepository.delete(userCd)
    }

    fun create(user: User, authorityKbn: String, password: String) {
        userRepository.createUser(user)
        userRepository.createCertification(
            userCd = user.userCd,
            authorityKbn = authorityKbn,
            password = password,
            createUser = user.createUser,
            createDateTime = user.createDateTime
        )
    }

    fun update(user: User, loginUser: String) {
        val oldUser = userRepository.getOneUser(userCd = user.userCd)
            userRepository.update(
                user = user,
                oldUser = oldUser,
                loginUser = loginUser

            )
    }

    fun updatePassword(userCd: String, passwordNew: String?, loginUser: String) {
        val certification = userRepository.getOneUserCertification(userCd)
        passwordNew?.let {
            userRepository.updatePassword(
                userCd = certification.userCd,
                passwordNow = passwordNew,
                passwordBefore = certification.passwordNow,
                loginUser = loginUser
            )
        }
    }

    fun updateUserAuth(
        userCd: String,
        authorityKbn: String,
        loginUser: String
    ) {
        userRepository.updateUserAuth(
            userCd = userCd,
            authorityKbn = authorityKbn,
            loginUser = loginUser
        )
    }
}