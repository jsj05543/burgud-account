package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Authority
import jp.co.burgud.burgudaccount.app.domain.entity.Country

interface AuthorityRepository {
    fun getAllAuthority(): List<Authority>

    fun getAuthorityKbnList(): List<String>

    fun update(authorityList: List<Authority>)

    fun create(authority: Authority)
}