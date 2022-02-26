package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.UserRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
internal interface UserMapper {
    @Select("SELECT * FROM user")
    fun findAll(): List<UserRecord>

    @Select("SELECT userCd FROM user")
    fun findUserCdList(): List<String>
}