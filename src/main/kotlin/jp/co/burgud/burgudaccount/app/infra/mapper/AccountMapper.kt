package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.AccountRecord
import org.apache.ibatis.annotations.*

@Mapper
internal interface AccountMapper {
    @Select("SELECT * FROM account")
    fun findAll(): List<AccountRecord>

    @Select("SELECT account_cd FROM account")
    fun findAccountCdList(): List<String>

    @Select(
        """
        SELECT * FROM account WHERE account_cd = #{accountCd}
    """
    )
    fun findByAccountCd(accountCd: String): AccountRecord

    @Select(
        """
        <script>
            SELECT
                account_cd,
                account_used_name,
                used_detail,
                account_name,
                account_password,
                country_kbn,
                facility_kbn,
                query1,
                answer1,
                query2,
                answer2,
                query3,
                answer3,
                oldPassword1,
                oldPassword2,
                oldPassword3,
                biko,
                create_user,
                create_at,
                update_user,
                update_at
            From
                account
            <where>
                used_flg = 0 
                <if test="countryKbn != null and countryKbn != all">
                    AND country_kbn = #{countryKbn}
                </if>
                <if test="keyword != null">
                    AND (account_name LIKE CONCAT('%', #{keyword}, '%') OR account_used_name LIKE CONCAT('%', #{keyword}, '%'))
                </if>       
            </where>
        </script>
    """)
    fun findAccountListByCountryKbnAndKeyword(countryKbn: String?, keyword: String?,all:String): List<AccountRecord>

    @Select("""SELECT id, val FROM question""")
    fun findAllQuestion(): List<Pair<Int, String>>

    @Select("""SELECT id, val FROM answer""")
    fun findAllAnswer(): List<Pair<Int, String>>

    @Update(
        """
        UPDATE account 
        SET
		    account_used_name   = #{accountUsedName},
		    used_detail        = #{usedDetail},
		    account_name       = #{accountName},
		    account_password   = #{accountPassword},
		    country_kbn        = #{countryKbn},
		    facility_kbn       = #{facilityKbn},
		    query1            = #{query1},
		    answer1           = #{answer1},
		    query2            = #{query2},
		    answer2           = #{answer2},
		    query3            = #{query3},
		    answer3           = #{answer3},
		    oldPassword1      = #{oldPassword1},
		    oldPassword2      = #{oldPassword2},
		    oldPassword3      = #{oldPassword3},
		    biko              = #{biko}
		WHERE 
            account_cd         = #{accountCd}
    """
    )
    fun update(record: AccountRecord)

    @Insert(
        """
        INSERT INTO account
        SET
            account_cd         = #{accountCd},
            account_used_name   = #{accountUsedName},
		    used_detail        = #{usedDetail},
		    account_name       = #{accountName},
		    account_password   = #{accountPassword},
		    country_kbn        = #{countryKbn},
		    facility_kbn       = #{facilityKbn},
		    query1            = #{query1},
		    answer1           = #{answer1},
		    query2            = #{query2},
		    answer2           = #{answer2},
		    query3            = #{query3},
		    answer3           = #{answer3},
		    oldPassword1      = #{oldPassword1},
		    oldPassword2      = #{oldPassword2},
		    oldPassword3      = #{oldPassword3},
		    biko              = #{biko},
		    create_user       = #{createUser},
		    create_at         = #{createAt}
    """
    )
    fun insert(record: AccountRecord)

    @Delete("""DELETE FROM account WHERE account_cd = #{accountCd}""")
    fun delete(accountCd: String)
}