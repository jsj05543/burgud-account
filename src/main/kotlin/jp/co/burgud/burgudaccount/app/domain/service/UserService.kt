package jp.co.burgud.burgudaccount.app.domain.service

import jp.co.burgud.burgudaccount.app.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getUserCdList(): List<String> {
        return userRepository.getUserCdList()
    }


}