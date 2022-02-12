package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.CountryMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import jp.co.burgud.burgudaccount.common.entity.Country
import org.springframework.stereotype.Repository

@Repository
internal class CountryRepositoryImpl(
   private val countryMapper: CountryMapper
): CountryRepository {
    override fun getAllCountry(): List<Country> {
        return countryMapper.findAll().map { it.toEntity() }
    }
}