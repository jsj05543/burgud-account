package jp.co.burgud.burgudaccount.app.domain.usecase

import jp.co.burgud.burgudaccount.app.domain.query.PrefAndCityQuery
import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.domain.entity.*
import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import org.springframework.stereotype.Component


@Component
class PrefAndCityUseCase(
    val prefAndCityQuery: PrefAndCityQuery
) {
    fun getPrefData(): Map<String, String> {
        return prefAndCityQuery.findAllPref().map {
            it.prefCode.toString() to it.prefName
        }.toMap()
    }

    fun getCityData(): Map<String, String> {
        return prefAndCityQuery.findAllCity().map {
            (it.prefCode.toString() + it.cityCode.toString()) to it.cityName
        }.toMap()
    }


}