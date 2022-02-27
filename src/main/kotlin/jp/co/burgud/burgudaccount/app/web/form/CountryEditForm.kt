package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.app.domain.entity.Country
import lombok.NoArgsConstructor

@NoArgsConstructor
data class CountryEditForm(
    var countryList: List<Country> = mutableListOf()
)