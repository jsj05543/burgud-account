package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.CertificationRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.UserRecord
import org.apache.ibatis.annotations.*
import java.time.LocalDateTime


@Mapper
internal interface UserMapper {
    @Select("SELECT * FROM user")
    fun findAll(): List<UserRecord>

    @Select("SELECT * FROM user WHERE user_cd = #{userCd}")
    fun findByUserCd(userCd: String): UserRecord

    @Select("SELECT * FROM certification WHERE user_cd = #{userCd}")
    fun findCertificationByUserCd(userCd: String): CertificationRecord

    @Select("SELECT user_cd FROM user")
    fun findUserCdList(): List<String>

    @Insert(
        """
		INSERT INTO `user`
        SET
            user_cd         = #{userCd},
		    email           = #{email},
            full_name       = #{fullName},
		    first_name      = #{firstName},
		    last_name       = #{lastName},
		    sex             = #{sex},
		    birth           = #{birth},
		    tel             = #{tel},
		    zip             = #{zip},
		    address         = #{address},
		    nutag_pref      = #{nutagPref},
		    nutag_city      = #{nutagCity},
		    send_mail_flg   = #{sendMailFlg},
		    create_user     = #{createUser},
		    create_at       = #{createAt}
    """
    )
    fun insertUser(record: UserRecord)

    @Insert(
        """
        INSERT INTO `certification`
        SET
            `user_cd`          = #{userCd},
            `authority_kbn`    = #{authorityKbn}, 
            `password_now`     = #{password},
             create_user       = #{createUser},
		     create_at         = #{createAt}
    """
    )
    fun insertCertification(
        userCd: String,
        authorityKbn: String,
        password: String,
        createUser: String,
        createAt: LocalDateTime
    )

    @Update(
        """
        UPDATE `user` 
        SET
		    first_name    = #{firstName},
		    last_name     = #{lastName},
		    sex           = #{sex},
		    birth         = #{birth},
		    tel           = #{tel},
		    zip           = #{zip},
		    address       = #{address},
		    nutag_pref    = #{nutagPref},
		    nutag_city    = #{nutagCity},
		    send_mail_flg = #{sendMailFlg},
		    update_user   = #{updateUser},
		    update_at     = #{updateAt}
		WHERE 
            user_cd       = #{userCd}
    """
    )
    fun update(userRecord: UserRecord)

    @Update(
        """
        UPDATE `certification` 
        SET 
            user_cd         = #{userCd},
            password_now    = #{passwordNow},
            password_before = #{passwordBefore},
            update_user     = #{updateUser},
            update_at       = #{updateAt} 
        WHERE 
            user_cd = #{userCd}
    """
    )
    fun updatePassword(
        userCd: String,
        passwordNow: String,
        passwordBefore: String,
        updateUser: String,
        updateAt: LocalDateTime

    )

    @Update(
        """
        UPDATE `certification` 
        SET 
            authority_kbn = #{authorityKbn},
            update_user = #{updateUser},
            update_at = #{updateAt} 
        WHERE 
            user_cd = #{userCd}
    """
    )
    fun updateUserAuth(
        userCd: String,
        authorityKbn: String,
        updateUser: String,
        updateAt: LocalDateTime
    )

    @Delete("DELETE FROM certification WHERE user_cd = #{userCd}")
    fun deleteCertification(userCd: String)

    @Delete("DELETE FROM user WHERE user_cd = #{userCd}")
    fun deleteUser(userCd: String)
}