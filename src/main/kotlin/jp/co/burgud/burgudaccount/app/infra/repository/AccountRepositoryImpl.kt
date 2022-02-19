package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.repository.AccountRepository
import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import jp.co.burgud.burgudaccount.app.domain.repository.CountryRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.AccountMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.AuthorityMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.CountryMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import jp.co.burgud.burgudaccount.common.entity.Account
import jp.co.burgud.burgudaccount.common.entity.Authority
import jp.co.burgud.burgudaccount.common.entity.Country
import org.springframework.stereotype.Repository

@Repository
internal class AccountRepositoryImpl(
   private val accountMapper: AccountMapper
): AccountRepository {

    override fun getAllAccount(): List<Account> {
        return accountMapper.findAll().map { it.toEntity() }
    }
}