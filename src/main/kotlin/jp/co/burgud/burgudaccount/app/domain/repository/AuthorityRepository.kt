package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.common.entity.Authority
import jp.co.burgud.burgudaccount.common.entity.Country

interface AuthorityRepository {
    fun getAllAuthority(): List<Authority>
}