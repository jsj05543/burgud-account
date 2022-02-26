package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.CertificationRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.UserRecord
import org.apache.ibatis.annotations.*


@Mapper
internal interface UserMapper {
    @Select("SELECT * FROM user")
    fun findAll(): List<UserRecord>

    @Select("SELECT * FROM user WHERE userCd = #{userCd}")
    fun findByUserCd(userCd: String): UserRecord

    @Select("SELECT * FROM certification WHERE userCd = #{userCd}")
    fun findCertificationByUserCd(userCd: String): CertificationRecord

    @Select("SELECT userCd FROM user")
    fun findUserCdList(): List<String>

    @Insert(
        """
		INSERT INTO `user`
        SET
            userCd =    #{userCd},
		    email = 	#{email},
            fullName =  #{fullName},
		    firstName = #{firstName},
		    lastName =  #{lastName},
		    sex =       #{sex},
		    birth =     #{birth},
		    tel =       #{tel},
		    zip =       #{zip},
		    address =   #{address},
		    nutagPref = #{nutagPref},
		    nutagCity = #{nutagCity},
		    sendMailFlg = #{sendMailFlg}
    """
    )
    fun insertUser(record: UserRecord)

    @Insert(
        """
        INSERT INTO `certification`
        SET
            `userCd`          = #{userCd},
            `authorityKbn`    = #{authorityKbn}, 
            `password1`       = #{password}
    """
    )
    fun insertCertification(userCd: String, authorityKbn: String, password: String)

    @Update(
        """
        UPDATE `user` 
        SET
		    firstName=#{firstName},
		    lastName=#{lastName},
		    sex=#{sex},
		    birth=#{birth},
		    tel=#{tel},
		    zip=#{zip},
		    address=#{address},
		    nutagPref=#{nutagPref},
		    nutagCity=#{nutagCity},
		    sendMailFlg=#{sendMailFlg}
		WHERE 
            userCd=#{userCd}
    """
    )
    fun update(userRecord: UserRecord)

    @Update(
        """
        UPDATE `certification` 
        SET 
            userCd = #{userCd},
            password1 = #{password1},
            password2 = #{password2} 
        WHERE 
            userCd = #{userCd}
    """
    )
    fun updatePassword(
        userCd: String,
        password1: String,
        password2: String
    )

    @Update(
        """
        UPDATE `certification` 
        SET 
            authorityKbn = #{authorityKbn} 
        WHERE 
            userCd = #{userCd}
    """
    )
    fun updateUserAuth(userCd: String, authorityKbn: String)


    @Delete("DELETE FROM certification WHERE userCd = #{userCd}")
    fun deleteCertification(userCd: String)

    @Delete("DELETE FROM user WHERE userCd = #{userCd}")
    fun deleteUser(userCd: String)
}