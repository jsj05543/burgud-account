package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.CountryMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.FacilityMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.UserMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import jp.co.burgud.burgudaccount.common.entity.Country
import jp.co.burgud.burgudaccount.common.entity.Facility
import jp.co.burgud.burgudaccount.common.entity.User
import org.springframework.stereotype.Repository

@Repository
internal class UserRepositoryImpl(
   private val userMapper: UserMapper
): UserRepository {
    override fun getAllUser(): List<User> {
        return userMapper.findAll().map { it.toEntity() }
    }
}