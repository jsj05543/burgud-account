package jp.co.burgud.burgudaccount.app.domain.query

import jp.co.burgud.burgudaccount.app.domain.entity.City
import jp.co.burgud.burgudaccount.app.domain.entity.Pref

interface PrefAndCityQuery {
    fun findAllPref(): List<Pref>

    fun findAllCity(): List<City>

    fun findCityByPrefCode(): List<City>
}