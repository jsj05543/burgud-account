package jp.co.burgud.burgudaccount.common.util

import jp.co.burgud.burgudaccount.app.domain.query.PrefQuery
import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.common.entity.*
import org.springframework.stereotype.Component


@Component
class GeneralLojic(
    val prefQuery: PrefQuery,
    val facilityRepository: FacilityRepository,
    val countryRepository: CountryRepository
) {
    fun getSexData(): Map<String, String> {
        return Sex.asMap()
    }

    fun getPrefData(): Map<String, String>? {
        val selectMap: MutableMap<String, String> = LinkedHashMap()
        val prefList: List<Pref> = prefQuery.findAllPref()
        for (pref in prefList) {
            selectMap[java.lang.String.valueOf(pref.prefCode)] = pref.prefName
        }
        return selectMap
    }

    fun getCityData(): Map<String, String>? {
        val selectMap: MutableMap<String, String> = LinkedHashMap()
        val cityList: List<City> = prefQuery.findAllCity()
        for (city in cityList) {
            val key = city.prefCode.toString() + city.cityCode.toString()
            selectMap[key] = city.cityName
        }
        return selectMap
    }

    fun getCountryData(): Map<String, String> {
        val selectMap: MutableMap<String, String> = LinkedHashMap()
        val countryList: List<Country> = countryRepository.getCountry()
        for (country: Country in countryList) {
            selectMap[country.countryKbn] = country.countryName
        }
        return selectMap
    }

    fun getFacilityData(): Map<String, String> {
        val selectMap: MutableMap<String, String> = LinkedHashMap()
        val facilityList: List<Facility> = facilityRepository.getFacility()
        for (facility: Facility in facilityList) {
            selectMap[facility.facilityKbn] = facility.facilityName
        }
        return selectMap
    }
}