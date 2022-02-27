package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Account
import jp.co.burgud.burgudaccount.app.domain.repository.AccountRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.AccountMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.AccountRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
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

    override fun update(account: Account) {

        val record = AccountRecord(
            accountCd = account.accountCd,
            accountUsedName = account.accountUsedName,
            usedDetail = account.usedDetail,
            accountName = account.accountName,
            accountPassword = account.accountPassword,
            countryKbn = account.countryKbn,
            facilityKbn = account.facilityKbn,
            query1 = account.query1,
            answer1 = account.answer1,
            query2 = account.query2,
            answer2 = account.answer2,
            query3 = account.query3,
            answer3 = account.answer3,
            oldPassword1 = account.oldPassword1,
            oldPassword2 = account.oldPassword2,
            oldPassword3 = account.oldPassword3,
            biko = account.biko,
            createUser = account.createUser,
            createDateTime = account.createDateTime,
            updateUser = account.updateUser,
            updateDateTime = account.updateDateTime
        )
        accountMapper.update(record)
    }

    override fun create(account: Account) {
        val record = AccountRecord(
            accountCd = account.accountCd,
            accountUsedName = account.accountUsedName,
            usedDetail = account.usedDetail,
            accountName = account.accountName,
            accountPassword = account.accountPassword,
            countryKbn = account.countryKbn,
            facilityKbn = account.facilityKbn,
            query1 = account.query1,
            answer1 = account.answer1,
            query2 = account.query2,
            answer2 = account.answer2,
            query3 = account.query3,
            answer3 = account.answer3,
            oldPassword1 = account.oldPassword1,
            oldPassword2 = account.oldPassword2,
            oldPassword3 = account.oldPassword3,
            biko = account.biko,
            createUser = account.createUser,
            createDateTime = account.createDateTime,
            updateUser = account.updateUser,
            updateDateTime = account.updateDateTime
        )
        accountMapper.insert(record)
    }

    override fun delete(accountCd: String) {
        return accountMapper.delete(accountCd)
    }
}