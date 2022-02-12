package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.CountryRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.FacilityRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
internal interface FacilityMapper {
    @Select("SELECT * FROM facility")
    fun findAll(): List<FacilityRecord>
}