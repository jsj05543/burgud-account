package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.UserMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import jp.co.burgud.burgudaccount.app.domain.entity.User
import org.springframework.stereotype.Repository

@Repository
internal class UserRepositoryImpl(
    private val userMapper: UserMapper
) : UserRepository {
    override fun getAllUser(): List<User> {
        return userMapper.findAll().map { it.toEntity() }
    }

    override fun getUserCdList(): List<String> {
        return userMapper.findUserCdList()
    }
}