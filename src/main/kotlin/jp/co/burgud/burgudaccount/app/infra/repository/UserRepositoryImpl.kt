package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Certification
import jp.co.burgud.burgudaccount.app.domain.entity.User
import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.UserMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.UserRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
internal class UserRepositoryImpl(
    private val userMapper: UserMapper
) : UserRepository {
    override fun getAllUser(): List<User> {
        return userMapper.findAll().map { it.toEntity() }
    }

    override fun getOneUser(userCd: String): User {
        return userMapper.findByUserCd(userCd).toEntity()
    }

    override fun getUserName(userCd: String): String {
        return userMapper.findUserNameByUserCd(userCd)
    }

    override fun getOneUserCertification(userCd: String): Certification {
        return userMapper.findCertificationByUserCd(userCd).toEntity()
    }

    override fun getUserCdList(): List<String> {
        return userMapper.findUserCdList()
    }

    override fun createUser(user: User) {
        val userRecord = UserRecord(
            userCd = user.userCd,
            email = user.email,
            fullName = user.firstName + user.lastName,
            firstName = user.firstName,
            lastName = user.lastName,
            sex = user.sex,
            birth = user.birth,
            tel = user.tel,
            zip = user.zip,
            address = user.address,
            nutagPref = user.nutagPref,
            nutagCity = user.nutagCity,
            sendMailFlg = user.sendMailFlg,
            createUser = user.createUser,
            createAt = user.createAt,
            updateUser = null,
            updateAt = null
        )
        userMapper.insertUser(userRecord)
    }

    override fun createCertification(
        userCd: String,
        authorityKbn: String,
        password: String,
        createUser: String,
        createAt: LocalDateTime
    ) {
        userMapper.insertCertification(
            userCd = userCd,
            authorityKbn = authorityKbn,
            password = password,
            createUser = createUser,
            createAt = createAt,
        )
    }

    override fun update(user: User, oldUser: User, loginUser: String) {
        val userRecord = UserRecord(
            userCd = user.userCd,
            email = user.email,
            fullName = user.firstName + user.lastName,
            firstName = user.firstName,
            lastName = user.lastName,
            sex = user.sex,
            birth = user.birth,
            tel = user.tel,
            zip = user.zip,
            address = user.address,
            nutagPref = user.nutagPref,
            nutagCity = user.nutagCity,
            sendMailFlg = user.sendMailFlg,
            createUser = oldUser.createUser,
            createAt = oldUser.createAt,
            updateUser = loginUser,
            updateAt = LocalDateTime.now()
        )
        userMapper.update(userRecord)
    }

    override fun updatePassword(
        userCd: String,
        passwordNow: String,
        passwordBefore: String,
        loginUser: String,
    ) {
        userMapper.updatePassword(
            userCd = userCd,
            passwordNow = passwordNow,
            passwordBefore = passwordBefore,
            updateUser = loginUser,
            updateAt = LocalDateTime.now()
        )
    }

    override fun updateUserAuth(
        userCd: String,
        authorityKbn: String,
        loginUser: String
    ) {
        userMapper.updateUserAuth(
            userCd = userCd,
            authorityKbn = authorityKbn,
            updateUser = loginUser,
            updateAt = LocalDateTime.now()
        )
    }

    override fun delete(userCd: String) {
        userMapper.deleteCertification(userCd)
        userMapper.deleteUser(userCd)
    }
}