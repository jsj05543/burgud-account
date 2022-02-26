package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Certification
import jp.co.burgud.burgudaccount.app.domain.entity.User

interface UserRepository {
    fun getAllUser(): List<User>

    fun getOneUser(userCd: String): User

    fun getOneUserCertification(userCd: String): Certification

    fun getUserCdList(): List<String>

    fun createUser(user: User)

    fun createCertification(userCd: String, authorityKbn: String, password: String)

    fun update(user: User)

    fun updatePassword(
        userCd: String,
        passwordNew: String,
        passwordOld: String
    )

    fun updateUserAuth(
        userCd: String,
        authorityKbn: String,
    )

    //fun createCertification(certification: Certification)

    fun delete(userCd: String)

}