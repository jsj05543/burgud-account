package jp.co.burgud.burgudaccount.app.domain.usecase

import jp.co.burgud.burgudaccount.app.domain.entity.Country
import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.domain.service.CountryService
import jp.co.burgud.burgudaccount.app.domain.service.CreateKbnService
import org.springframework.stereotype.Component
import java.time.LocalDateTime

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

    fun create(
        countryKbn: String,
        countryName: String?,
        loginUser: String
    ) {
        if (countryName != null) {
            val country = Country(
                countryKbn = countryKbn,
                countryName = countryName,
                createUser = loginUser,
                createAt = LocalDateTime.now(),
                updateUser = null,
                updateAt = null
            )
            countryRepository.create(country)
        }
    }

    fun updateCountry(
        countryList: List<Country>,
        loginUser: String
    ) {
        countryRepository.update(
            countryList = countryList,
            loginUser = loginUser
        )
    }
}