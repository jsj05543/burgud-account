package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.app.domain.entity.Authority
import lombok.NoArgsConstructor

@NoArgsConstructor
data class AuthorityForm(
    val authorityList: List<Authority>
)