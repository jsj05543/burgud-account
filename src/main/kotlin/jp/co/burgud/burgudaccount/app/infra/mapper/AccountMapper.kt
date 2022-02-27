package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.AccountRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

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
}