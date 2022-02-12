package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.common.entity.Country
import lombok.NoArgsConstructor

@NoArgsConstructor
data class CountryForm(
   // val country: Country,
    val countryList: List<Country>
)