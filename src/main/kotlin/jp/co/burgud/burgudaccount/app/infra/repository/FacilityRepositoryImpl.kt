package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Facility
import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.FacilityMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.FacilityRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
internal class FacilityRepositoryImpl(
    private val facilityMapper: FacilityMapper
) : FacilityRepository {
    override fun getAllFacility(): List<Facility> {
        return facilityMapper.findAll().map { it.toEntity() }
    }

    override fun getFacilityKbnList(): List<String> {
        return facilityMapper.findFacilityKbnList()
    }

    override fun update(facilityList: List<Facility>) {
        facilityMapper.delete()

        val facilityRecords = facilityList.filter { it.facilityName != "" }.map {
            FacilityRecord(
                facilityKbn = it.facilityKbn,
                facilityName = it.facilityName,
                createUser = "AA",
                createDateTime = LocalDateTime.now(),
                updateUser = "BB",
                updateDateTime = LocalDateTime.now(),
            )
        }
        facilityMapper.insertBulk(facilityRecords)
    }

    override fun create(facility: Facility) {
        val facilityRecord = FacilityRecord(
            facilityKbn = facility.facilityKbn,
            facilityName = facility.facilityName,
            createUser = "AA",
            createDateTime = LocalDateTime.now(),
            updateUser = "BB",
            updateDateTime = LocalDateTime.now(),
        )
        facilityMapper.insert(facilityRecord)
    }
}