package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.CityRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.PrefRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
internal interface PrefAndCityMapper {
    @Select(
        """
        SELECT 
            pref_code,
            pref_name 
        FROM 
            pref 
        WHERE 
            dis_flag = 0
    """
    )
    fun findAllPref(): List<PrefRecord>

    @Select(
        """
        SELECT
            pref_code,
            city_code,
            city_name 
        FROM 
            city
    """
    )
    fun findAllCity(): List<CityRecord>

    @Select(
        """
        SELECT 
            pref_code, 
            city_code,
            city_name 
       FROM 
            city 
       WHERE
            pref_code = #{prefCode}
   """
    )
    fun findCityByPrefCode(prefCode: Int): List<CityRecord>
}