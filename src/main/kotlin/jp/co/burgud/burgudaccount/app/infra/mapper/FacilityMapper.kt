package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.FacilityRecord
import jp.co.burgud.burgudaccount.common.entity.Country
import jp.co.burgud.burgudaccount.common.entity.Facility
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.jdbc.core.BeanPropertyRowMapper


@Mapper
internal interface FacilityMapper {
    @Select("SELECT * FROM facility")
    fun findAll(): List<FacilityRecord>

    @Select("SELECT * FROM facility")
    fun selectFacility(): List<FacilityRecord>
}