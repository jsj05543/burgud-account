package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.common.entity.Country
import jp.co.burgud.burgudaccount.common.entity.Facility
import jp.co.burgud.burgudaccount.common.entity.User

interface UserRepository {
    fun getAllUser(): List<User>
}