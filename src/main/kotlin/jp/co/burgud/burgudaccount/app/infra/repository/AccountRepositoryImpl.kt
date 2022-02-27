package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.repository.AccountRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.AccountMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import jp.co.burgud.burgudaccount.app.domain.entity.Account
import org.springframework.stereotype.Repository

@Repository
internal class AccountRepositoryImpl(
    private val accountMapper: AccountMapper
) : AccountRepository {

    override fun getAllAccount(): List<Account> {
        return accountMapper.findAll().map { it.toEntity() }
    }

    override fun getAccountCdList(): List<String> {
        return accountMapper.findAccountCdList()
    }

    override fun findAccountListByCountryKbnAndKeyword(countryKbn: String, keyword: String): List<Account> {
        TODO("Not yet implemented")
    }

    override fun getOneAccount(accountCd: String): Account {
        return accountMapper.findByAccountCd(accountCd).toEntity()
    }

    override fun getAllQuestion(): List<Pair<Int, String>> {
        return accountMapper.findAllQuestion()
    }

    override fun getAllAnswer(): List<Pair<Int, String>> {
        return accountMapper.findAllAnswer()
    }
}