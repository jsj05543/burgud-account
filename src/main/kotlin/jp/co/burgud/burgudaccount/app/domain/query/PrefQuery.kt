package jp.co.burgud.burgudaccount.app.domain.query

import jp.co.burgud.burgudaccount.common.entity.City
import jp.co.burgud.burgudaccount.common.entity.Country
import jp.co.burgud.burgudaccount.common.entity.Facility
import jp.co.burgud.burgudaccount.common.entity.Pref

interface PrefQuery {
    fun findAllPref(): List<Pref>

    fun findAllCity(): List<City>

    fun findCityByPrefCode(): List<City>
}