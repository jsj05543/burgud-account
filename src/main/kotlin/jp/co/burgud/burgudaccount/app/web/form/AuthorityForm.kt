package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.common.entity.Authority
import jp.co.burgud.burgudaccount.common.entity.Country
import lombok.NoArgsConstructor

@NoArgsConstructor
data class AuthorityForm(
    val authorityList: List<Authority>
)