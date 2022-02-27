package jp.co.burgud.burgudaccount.app.web.form


import lombok.NoArgsConstructor

@NoArgsConstructor
data class AccountSearchForm(
    val countryKbn: String?,
    val keyword: String?
)