package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.app.domain.entity.Country
import lombok.NoArgsConstructor
import org.springframework.lang.NonNull
import javax.validation.Valid

@NoArgsConstructor
data class CountryEditForm(
    @field:[Valid NonNull]
    var countryList: List<Country> = mutableListOf()
)