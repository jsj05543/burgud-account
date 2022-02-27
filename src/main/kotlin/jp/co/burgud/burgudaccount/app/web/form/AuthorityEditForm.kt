package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.app.domain.entity.Authority
import lombok.NoArgsConstructor

@NoArgsConstructor
data class AuthorityEditForm(
    var authorityList: List<Authority> = mutableListOf()
)