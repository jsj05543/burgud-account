package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Authority
import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.AuthorityMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.AuthorityRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import org.springframework.stereotype.Repository

@Repository
internal class AuthorityRepositoryImpl(
    private val authorityMapper: AuthorityMapper
) : AuthorityRepository {

    override fun getAllAuthority(): List<Authority> {
        return authorityMapper.findAll().map { it.toEntity() }
    }

    override fun getAuthorityKbnList(): List<String> {
        return authorityMapper.findAuthorityKbnList()
    }

    override fun update(authorityList: List<Authority>, loginUser: String) {
        authorityMapper.delete()

        val authorityRecords = authorityList.filter { it.authorityName != "" }.map {
            AuthorityRecord(
                authorityKbn = it.authorityKbn,
                authorityName = it.authorityName,
                createUser = loginUser,
                createAt = it.createAt,
                updateUser = null,
                updateAt = null,
            )
        }
        authorityMapper.insertBulk(authorityRecords)
    }

    override fun create(authority: Authority) {
        val authorityRecord = AuthorityRecord(
            authorityKbn = authority.authorityKbn,
            authorityName = authority.authorityName,
            createUser = authority.createUser,
            createAt = authority.createAt,
            updateUser = null,
            updateAt = null,
        )
        authorityMapper.insert(authorityRecord)
    }
}