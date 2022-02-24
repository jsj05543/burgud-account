package jp.co.burgud.burgudaccount.app.domain.service

import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import org.springframework.stereotype.Service

@Service
class CountryService(
    private val countryRepository: CountryRepository
) {
    fun getCountryKbnList(): List<String> {
        return countryRepository.getAuthorityKbnList()
    }
}