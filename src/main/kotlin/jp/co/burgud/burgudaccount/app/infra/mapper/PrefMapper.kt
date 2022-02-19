package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.CityRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.PrefRecord
import jp.co.burgud.burgudaccount.common.entity.City
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.SqlParameterSource


@Mapper
internal interface PrefMapper {
    @Select("SELECT prefCode,prefName FROM pref WHERE disFlag=0")
    fun findAllPref(): List<PrefRecord>

    @Select("SELECT prefCode,cityCode,cityName FROM city")
    fun findAllCity(): List<CityRecord>

    @Select("SELECT cityCode,cityName FROM city WHERE prefCode =:prefCode")
    fun findCityByPrefCode(prefCode: Int): List<CityRecord>
}