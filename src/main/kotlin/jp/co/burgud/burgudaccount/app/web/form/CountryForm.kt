package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.app.domain.entity.Country
import jp.co.burgud.burgudaccount.app.web.message.BusinessMessages
import lombok.NoArgsConstructor
import java.time.LocalDateTime

data class CountryForm(
    val countryKbn: String,
    val countryName: String?
)