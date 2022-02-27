package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.CountryRecord
import org.apache.ibatis.annotations.*

@Mapper
internal interface CountryMapper {
    @Select("""SELECT * FROM country""")
    fun findAll(): List<CountryRecord>

    @Select("""SELECT country_kbn FROM country""")
    fun findCountryKbnList(): List<String>

    @Insert(
        """
        INSERT INTO `country`
        SET
            `country_kbn`     = #{countryKbn},
            `country_name`    = #{countryName},
            `create_user`     = #{createUser} 
    """
    )
    fun insert(record: CountryRecord)

    @Insert(
        """
        <script>
            INSERT INTO `country`
                (
                    country_kbn,
                    country_name,
                    create_user
                )
            VALUES
            <foreach collection='records' item='record' separator=',' >
            (
                #{record.countryKbn},
                #{record.countryName},
                #{record.createUser}
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