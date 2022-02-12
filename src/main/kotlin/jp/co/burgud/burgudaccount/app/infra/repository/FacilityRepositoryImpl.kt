package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.CountryMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.FacilityMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import jp.co.burgud.burgudaccount.common.entity.Country
import jp.co.burgud.burgudaccount.common.entity.Facility
import org.springframework.stereotype.Repository

@Repository
internal class FacilityRepositoryImpl(
   private val facilityMapper: FacilityMapper
): FacilityRepository {
    override fun getAllAuthority(): List<Facility> {
        return facilityMapper.findAll().map { it.toEntity() }
    }
}