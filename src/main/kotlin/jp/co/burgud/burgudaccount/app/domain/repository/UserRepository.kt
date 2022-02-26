package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.app.domain.entity.User

interface UserRepository {
    fun getAllUser(): List<User>

    fun getUserCdList(): List<String>
}