package jp.co.burgud.burgudaccount.app.infra.query

import jp.co.burgud.burgudaccount.app.domain.entity.City
import jp.co.burgud.burgudaccount.app.domain.entity.Pref
import jp.co.burgud.burgudaccount.app.domain.query.PrefAndCityQuery
import jp.co.burgud.burgudaccount.app.infra.mapper.PrefAndCityMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import org.springframework.stereotype.Repository

@Repository
internal class PrefAndCityQueryImpl(
    private val prefAndCityMapper: PrefAndCityMapper
) : PrefAndCityQuery {
    override fun findAllPref(): List<Pref> {
        return prefAndCityMapper.findAllPref().map { it.toEntity() }
    }

    override fun findAllCity(): List<City> {
        return prefAndCityMapper.findAllCity().map { it.toEntity() }
    }

    override fun findCityByPrefCode(prefCode: Int): List<City> {
        return prefAndCityMapper.findCityByPrefCode(prefCode).map { it.toEntity() }
    }
}