package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Authority
import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.AuthorityMapper
import jp.co.burgud.burgudaccount.app.infra.mapper.record.AuthorityRecord
import jp.co.burgud.burgudaccount.app.infra.mapper.record.toEntity
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

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

    override fun update(authorityList: List<Authority>) {
        authorityMapper.delete()

        val authorityRecords = authorityList.filter { it.authorityName != "" }.map {
            AuthorityRecord(
                authorityKbn = it.authorityKbn,
                authorityName = it.authorityName,
                createUser = "AA",
                createDateTime = LocalDateTime.now(),
                updateUser = "BB",
                updateDateTime = LocalDateTime.now(),
            )
        }
        authorityMapper.insertBulk(authorityRecords)
    }

    override fun create(authority: Authority) {
        val authorityRecord = AuthorityRecord(
            authorityKbn = authority.authorityKbn,
            authorityName = authority.authorityName,
            createUser = "AA",
            createDateTime = LocalDateTime.now(),
            updateUser = "BB",
            updateDateTime = LocalDateTime.now(),
        )
        authorityMapper.insert(authorityRecord)
    }
}