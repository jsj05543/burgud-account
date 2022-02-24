package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Country

interface CountryRepository {
    fun getAllCountry(): List<Country>

    fun getAuthorityKbnList(): List<String>

    fun update(countryList: List<Country>)

    fun create(country: Country)
}