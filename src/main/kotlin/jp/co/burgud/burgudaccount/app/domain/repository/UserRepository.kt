package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Certification
import jp.co.burgud.burgudaccount.app.domain.entity.User
import java.time.LocalDateTime

interface UserRepository {
    fun getAllUser(): List<User>

    fun getOneUser(userCd: String): User

    fun getOneUserCertification(userCd: String): Certification

    fun getUserCdList(): List<String>

    fun createUser(user: User)

    fun createCertification(
        userCd: String,
        authorityKbn: String,
        password: String,
        createUser: String,
        createAt: LocalDateTime
    )

    fun update(user: User,oldUser: User, loginUser: String)

    fun updatePassword(
        userCd: String,
        passwordNow: String,
        passwordBefore: String,
        loginUser: String
    )

    fun updateUserAuth(
        userCd: String,
        authorityKbn: String,
        loginUser: String
    )

    //fun createCertification(certification: Certification)

    fun delete(userCd: String)

}