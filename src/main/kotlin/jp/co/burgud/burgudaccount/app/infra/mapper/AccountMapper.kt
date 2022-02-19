package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.AccountRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.AuthorityRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.CountryRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
internal interface AccountMapper {
    @Select("SELECT * FROM account")
    fun findAll(): List<AccountRecord>
}