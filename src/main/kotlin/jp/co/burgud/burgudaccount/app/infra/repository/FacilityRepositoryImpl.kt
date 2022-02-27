package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Facility
import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.FacilityMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.FacilityRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import org.springframework.stereotype.Repository

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

    override fun update(facilityList: List<Facility>, loginUser: String) {
        facilityMapper.delete()

        val facilityRecords = facilityList.filter { it.facilityName != "" }.map {
            FacilityRecord(
                facilityKbn = it.facilityKbn,
                facilityName = it.facilityName,
                createUser = loginUser,
                createDateTime = it.createDateTime,
                updateUser = null,
                updateDateTime = null,
            )
        }
        facilityMapper.insertBulk(facilityRecords)
    }

    override fun create(facility: Facility) {
        val facilityRecord = FacilityRecord(
            facilityKbn = facility.facilityKbn,
            facilityName = facility.facilityName,
            createUser = facility.createUser,
            createDateTime = facility.createDateTime,
            updateUser = null,
            updateDateTime = null,
        )
        facilityMapper.insert(facilityRecord)
    }
}