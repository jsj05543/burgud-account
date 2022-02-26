package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Certification
import jp.co.burgud.burgudaccount.app.domain.entity.User
import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.UserMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.UserRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import org.springframework.stereotype.Repository

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
            createDateTime = user.createDateTime,
            updateUser = user.updateUser,
            updateDateTime = user.updateDateTime
        )
        userMapper.insertUser(userRecord)
    }

    override fun createCertification(userCd: String, authorityKbn: String, password: String) {
        userMapper.insertCertification(
            userCd = userCd,
            authorityKbn = authorityKbn,
            password = password
        )
    }

    override fun update(user: User) {
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
            createDateTime = user.createDateTime,
            updateUser = user.updateUser,
            updateDateTime = user.updateDateTime
        )
        userMapper.update(userRecord)
    }

    override fun updatePassword(
        userCd: String,
        passwordNew: String,
        passwordOld: String
    ) {
        userMapper.updatePassword(
            userCd = userCd,
            password1 = passwordNew,
            password2 = passwordOld
        )
    }

    override fun updateUserAuth(userCd: String, authorityKbn: String) {
        userMapper.updateUserAuth(
            userCd = userCd,
            authorityKbn = authorityKbn
        )
    }

//    override fun createCertification(certification: Certification) {
//        val certificationRecord = CertificationRecord(
//            userCd = certification.userCd,
//            authorityKbn = certification.authorityKbn,
//            password1 = certification.password1,
//            password2 = certification.password2,
//            loginTime = certification.loginTime,
//            logoutTime = certification.logoutTime,
//            createUser = certification.createUser,
//            createDateTime = certification.createDateTime,
//            updateUser = certification.updateUser,
//            updateDateTime = certification.updateDateTime
//        )
//        userMapper.insertCertification(certificationRecord)
//    }

    override fun delete(userCd: String) {
        userMapper.deleteCertification(userCd)
        userMapper.deleteUser(userCd)
    }
}