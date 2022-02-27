package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.CountryMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import jp.co.burgud.burgudaccount.app.domain.entity.Country
import jp.co.burgud.burgudaccount.app.infra.mapper.record.CountryRecord
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
internal class CountryRepositoryImpl(
    private val countryMapper: CountryMapper
) : CountryRepository {
    override fun getAllCountry(): List<Country> {
        return countryMapper.findAll().map { it.toEntity() }
    }

    override fun getAuthorityKbnList(): List<String> {
        return countryMapper.findCountryKbnList()
    }

    override fun update(countryList: List<Country>) {
        countryMapper.delete()

        val countryRecords = countryList.filter { it.countryName != "" }. map {
            CountryRecord(
                countryKbn = it.countryKbn,
                countryName = it.countryName,
                createUser = "AA",
                createDateTime = LocalDateTime.now(),
                updateUser = "BB",
                updateDateTime = LocalDateTime.now(),
            )
        }
        countryMapper.insertBulk(countryRecords)
    }

    override fun create(country: Country) {
        val countryRecord = CountryRecord(
            countryKbn = country.countryKbn,
            countryName = country.countryName,
            createUser = "AA",
            createDateTime = LocalDateTime.now(),
            updateUser = "BB",
            updateDateTime = LocalDateTime.now(),
        )
        countryMapper.insert(countryRecord)
    }
}