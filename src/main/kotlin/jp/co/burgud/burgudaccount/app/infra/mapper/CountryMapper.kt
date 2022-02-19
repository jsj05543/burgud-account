package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.CountryRecord
import jp.co.burgud.burgudaccount.common.entity.Country
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.jdbc.core.BeanPropertyRowMapper

@Mapper
internal interface CountryMapper {
    @Select("SELECT * FROM country")
    fun findAll(): List<CountryRecord>

    @Select("SELECT * FROM country")
    fun selectCountry(): List<CountryRecord>
}