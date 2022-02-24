package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.CountryRecord
import org.apache.ibatis.annotations.*

@Mapper
internal interface CountryMapper {
    @Select("""SELECT * FROM country""")
    fun findAll(): List<CountryRecord>

    @Select("""SELECT countryKbn FROM country""")
    fun findCountryKbnList(): List<String>

    @Insert(
        """
        INSERT INTO `country`
        SET
            `countryKbn`     = #{countryKbn},
            `countryName`    = #{countryName} 
    """
    )
    fun insert(record: CountryRecord)

    @Insert(
        """
        <script>
            INSERT INTO `country`
                (
                    countryKbn,
                    countryName
                )
            VALUES
            <foreach collection='records' item='record' separator=',' >
            (
                #{record.countryKbn},
                #{record.countryName})
            )
            </foreach>
        </script>
        """
    )
    fun insertBulk(
        @Param("records") records: List<CountryRecord>
    )

    @Delete("""DELETE FROM country""")
    fun delete()
}