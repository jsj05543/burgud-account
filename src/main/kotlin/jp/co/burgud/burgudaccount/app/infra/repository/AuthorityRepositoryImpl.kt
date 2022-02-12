package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.AuthorityMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.CountryMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import jp.co.burgud.burgudaccount.common.entity.Authority
import jp.co.burgud.burgudaccount.common.entity.Country
import org.springframework.stereotype.Repository

@Repository
internal class AuthorityRepositoryImpl(
   private val authorityMapper: AuthorityMapper
): AuthorityRepository {
    override fun getAllAuthority(): List<Authority> {
        return authorityMapper.findAll().map { it.toEntity() }
    }
}