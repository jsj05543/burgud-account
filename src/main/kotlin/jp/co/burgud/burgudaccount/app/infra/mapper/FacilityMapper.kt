package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.FacilityRecord
import org.apache.ibatis.annotations.*

@Mapper
internal interface FacilityMapper {
    @Select("""SELECT * FROM facility""")
    fun findAll(): List<FacilityRecord>

    @Select("""SELECT facility_kbn FROM facility""")
    fun findFacilityKbnList(): List<String>

    @Insert(
        """
        INSERT INTO `facility`
        SET
            `facility_kbn`     = #{facilityKbn},
            `facility_name`    = #{facilityName} 
    """
    )
    fun insert(record: FacilityRecord)

    @Insert(
        """
        <script>
            INSERT INTO `facility`
                (
                    facility_kbn,
                    facility_name
                )
            VALUES
            <foreach collection='records' item='record' separator=',' >
            (
                #{record.facilityKbn},
                #{record.facilityName}
            )
            </foreach>
        </script>
        """
    )
    fun insertBulk(
        @Param("records") records: List<FacilityRecord>
    )

    @Delete("""DELETE FROM facility""")
    fun delete()
}