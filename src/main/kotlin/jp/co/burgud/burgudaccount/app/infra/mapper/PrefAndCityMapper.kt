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
            prefCode,
            prefName 
        FROM 
            pref 
        WHERE 
            disFlag = 0
    """
    )
    fun findAllPref(): List<PrefRecord>

    @Select(
        """
        SELECT
            prefCode,
            cityCode,
            cityName 
        FROM 
            city
    """
    )
    fun findAllCity(): List<CityRecord>

    @Select(
        """
        SELECT 
            prefCode, 
            cityCode,
            cityName 
       FROM 
            city 
       WHERE
            prefCode = #{prefCode}
   """
    )
    fun findCityByPrefCode(prefCode: Int): List<CityRecord>
}