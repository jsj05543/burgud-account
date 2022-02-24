package jp.co.burgud.burgudaccount.app.infra.query

import jp.co.burgud.burgudaccount.app.domain.query.PrefAndCityQuery
import jp.co.burgud.burgudaccount.app.infra.mapper.PrefMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import jp.co.burgud.burgudaccount.app.domain.entity.City
import jp.co.burgud.burgudaccount.app.domain.entity.Pref
import org.springframework.stereotype.Repository

@Repository
internal class PrefAndCityQueryImpl(
    private val prefMapper: PrefMapper
) : PrefAndCityQuery {
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