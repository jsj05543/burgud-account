package jp.co.burgud.burgudaccount.app.domain.usecase

import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.domain.service.CountryService
import jp.co.burgud.burgudaccount.app.domain.service.CreateKbnService
import org.springframework.stereotype.Component

@Component
class CountryUseCase(
    private val countryService: CountryService,
    private val createKbnService: CreateKbnService,
    private val countryRepository: CountryRepository
) {
    companion object {
        private const val COUNTRY_CODE = "COUNTRY"
        private const val COUNTRY_KBN_NEW = "CY00"
    }

    fun createNewCountryKbn(): String {
        val countryKbnList = countryService.getCountryKbnList()
        if (countryKbnList.isEmpty()) {
            return COUNTRY_KBN_NEW
        }
        return createKbnService.getCodeVal(COUNTRY_CODE) + createKbnService.getMaxKbn(countryKbnList)
    }

    fun getCountryData(): Map<String, String> {
        return countryRepository.getAllCountry().map {
            it.countryKbn to it.countryName
        }.toMap()
    }
}