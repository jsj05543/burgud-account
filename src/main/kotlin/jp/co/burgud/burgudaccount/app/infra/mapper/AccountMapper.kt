package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.AccountRecord
import org.apache.ibatis.annotations.*

@Mapper
internal interface AccountMapper {
    @Select("SELECT * FROM account")
    fun findAll(): List<AccountRecord>

    @Select("SELECT accountCd FROM account")
    fun findAccountCdList(): List<String>

    @Select(
        """
        SELECT * FROM account WHERE accountCd = #{accountCd}
    """
    )
    fun findByAccountCd(accountCd: String): AccountRecord

    @Select("""SELECT id, val FROM question""")
    fun findAllQuestion(): List<Pair<Int, String>>

    @Select("""SELECT id, val FROM answer""")
    fun findAllAnswer(): List<Pair<Int, String>>

    @Update(
        """
        UPDATE account 
        SET
		    accountUsedName   = #{accountUsedName},
		    usedDetail        = #{usedDetail},
		    accountName       = #{accountName},
		    accountPassword   = #{accountPassword},
		    countryKbn        = #{countryKbn},
		    facilityKbn       = #{facilityKbn},
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
            accountCd         = #{accountCd}
    """
    )
    fun update(record: AccountRecord)

    @Insert(
        """
        INSERT INTO account
        SET
            accountCd         = #{accountCd},
            accountUsedName   = #{accountUsedName},
		    usedDetail        = #{usedDetail},
		    accountName       = #{accountName},
		    accountPassword   = #{accountPassword},
		    countryKbn        = #{countryKbn},
		    facilityKbn       = #{facilityKbn},
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
    """
    )
    fun insert(record: AccountRecord)

    @Delete("""DELETE FROM account WHERE accountCd = #{accountCd}""")
    fun delete(accountCd: String)
}