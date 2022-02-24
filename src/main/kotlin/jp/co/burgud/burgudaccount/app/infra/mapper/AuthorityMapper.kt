package jp.co.burgud.burgudaccount.app.infra.mapper

import jp.co.burgud.burgudaccount.app.infra.mapper.record.AuthorityRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.CountryRecord
import org.apache.ibatis.annotations.*

@Mapper
internal interface AuthorityMapper {
    @Select(
        """
        SELECT * FROM authority
    """
    )
    fun findAll(): List<AuthorityRecord>

    @Select(
        """
        SELECT authorityKbn FROM authority
    """
    )
    fun findAuthorityKbnList(): List<String>

    @Insert(
        """
        INSERT INTO `authority`
        SET
            `authorityKbn`     = #{authorityKbn},
            `authorityName`    = #{authorityName} 
    """
    )
    fun insert(record: AuthorityRecord)

    @Insert(
        """
        <script>
            INSERT INTO `authority`
                (
                    authorityKbn,
                    authorityName
                )
            VALUES
            <foreach collection='records' item='record' separator=',' >
            (
                #{record.authorityKbn},
                #{record.authorityName})
            )
            </foreach>
        </script>
        """
    )
    fun insertBulk(
        @Param("records") records: List<AuthorityRecord>
    )

    @Delete("""DELETE FROM authority""")
    fun delete()
}