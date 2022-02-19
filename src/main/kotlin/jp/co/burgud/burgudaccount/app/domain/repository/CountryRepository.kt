package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.common.entity.Country

interface CountryRepository {
    fun getAllCountry(): List<Country>

    fun getCountry(): List<Country>

}