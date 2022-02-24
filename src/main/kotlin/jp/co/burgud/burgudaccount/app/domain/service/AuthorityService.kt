package jp.co.burgud.burgudaccount.app.domain.service

import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import org.springframework.stereotype.Service

@Service
class AuthorityService(
    private val authorityRepository: AuthorityRepository
) {
    fun getAuthorityKbnList(): List<String> {
        return authorityRepository.getAuthorityKbnList()
    }
}