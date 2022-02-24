package jp.co.burgud.burgudaccount.app.domain.usecase

import jp.co.burgud.burgudaccount.app.domain.repository.AuthorityRepository
import jp.co.burgud.burgudaccount.app.domain.service.AuthorityService
import jp.co.burgud.burgudaccount.app.domain.service.CreateKbnService
import org.springframework.stereotype.Component

@Component
class AuthorityUseCase(
    private val authorityService: AuthorityService,
    private val createKbnService: CreateKbnService,
    private val authorityRepository: AuthorityRepository
) {
    companion object {
        private const val AUTHORITY_CODE = "AUTHORITY"
        private const val AUTHORITY_KBN_NEW = "AY00"
    }

    fun createNewAuthorityKbn(): String {
        val authorityKbnList = authorityService.getAuthorityKbnList()
        if (authorityKbnList.isEmpty()) {
            return AUTHORITY_KBN_NEW
        }
        return createKbnService.getCodeVal(AUTHORITY_CODE) + createKbnService.getMaxKbn(authorityKbnList)
    }

    fun getAuthorityData(): Map<String, String> {
        return authorityRepository.getAllAuthority().map {
            it.authorityKbn to it.authorityName
        }.toMap()
    }
}