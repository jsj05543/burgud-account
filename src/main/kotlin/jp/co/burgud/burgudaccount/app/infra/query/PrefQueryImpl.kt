package jp.co.burgud.burgudaccount.app.infra.query

import jp.co.burgud.burgudaccount.app.domain.query.PrefQuery
import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.CountryMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.FacilityMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.PrefMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import jp.co.burgud.burgudaccount.common.entity.City
import jp.co.burgud.burgudaccount.common.entity.Country
import jp.co.burgud.burgudaccount.common.entity.Facility
import jp.co.burgud.burgudaccount.common.entity.Pref
import org.springframework.stereotype.Repository

@Repository
internal class PrefQueryImpl(
   private val prefMapper: PrefMapper
): PrefQuery {
    override fun findAllPref(): List<Pref> {
        return prefMapper.findAllPref().map { it.toEntity() }
    }

    override fun findAllCity(): List<City> {
        return prefMapper.findAllCity().map { it.toEntity() }
    }

    override fun findCityByPrefCode(): List<City> {
        return prefMapper.findAllCity().map { it.toEntity() }
    }
}