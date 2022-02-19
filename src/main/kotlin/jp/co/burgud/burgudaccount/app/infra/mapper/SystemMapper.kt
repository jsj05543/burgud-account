package jp.co.burgud.burgudaccount.app.infra.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
internal interface SystemMapper {
    @Select("SELECT num FROM pagecount")
    fun find(): Int

    @Update("UPDATE pagecount SET num=#{num}")
    fun update(num: Int)
}