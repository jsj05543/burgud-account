package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.LoginSessionRecord
import org.apache.ibatis.annotations.*

@Mapper
interface SystemMapper {
    @Select("SELECT num FROM pagecount")
    fun find(): Int

    @Update("UPDATE pagecount SET num = #{num}")
    fun update(num: Int)

    @Select("SELECT val FROM code where name = #{code}")
    fun findCodeValByCode(code: String): String

    @Select(
        """
        SELECT
            user.user_cd,
            user.full_name
        FROM
            user INNER JOIN certification ON
            user.user_cd = certification.user_cd
        WHERE
            user.email  = #{email} AND
            certification.password_now = #{password}
    """
    )
    fun findLoginUserCd(email: String, password: String): String?

    @Insert(
        """
        INSERT INTO login_session 
        SET
            user_cd    = #{userCd},
            session_id = #{sessionId},
            login_at   = #{loginAt},
            logout_at  = #{logoutAt}
                                    
    """
    )
    fun insertSession(record: LoginSessionRecord)

    @Select(
        """
        SELECT
            user_cd,
            session_id,
            login_at,
            logout_at
        FROM 
            login_session 
        WHERE 
            session_id = #{sid}
    """
    )
    fun findSession(sid: String): LoginSessionRecord?

    @Delete("""DELETE FROM login_session where session_id = #{sessionId}""")
    fun deleteSession(sessionId: String)
}
