package jp.co.burgud.burgudaccount.app.domain.service

import jp.co.burgud.burgudaccount.app.domain.repository.SystemRepository
import org.springframework.stereotype.Component

@Component
class CreateKbnService(
    private val systemRepository: SystemRepository
) {

    companion object {
        private const val CODE_COUNTRY = "COUNTRY"

        private const val CODE_FACILITY = "FACILITY"

        private const val CODE_AUTHORITY = "AUTHORITY"

        private const val CODE_USER = "USER"

        private const val CODE_ACCOUNT = "ACCOUNT"

        private const val CODE_DIGIT = "2"
    }

    fun getCodeVal(code: String): String {

        return when (code) {
            CODE_COUNTRY ->
                systemRepository.getCodeVal(CODE_COUNTRY)
            CODE_FACILITY ->
                systemRepository.getCodeVal(CODE_FACILITY)
            CODE_AUTHORITY ->
                systemRepository.getCodeVal(CODE_AUTHORITY)
            CODE_USER ->
                systemRepository.getCodeVal(CODE_USER)
            else -> systemRepository.getCodeVal(CODE_ACCOUNT)
        }
    }

    fun getMaxKbn(kbnList: List<String>): String {

        val kbnNumList = kbnList.map { strToIntSub(CODE_DIGIT.toInt(), it) }
        val newKbnNum = kbnNumList.maxOf { it } + 1
        return intToStrFormat(CODE_DIGIT, newKbnNum)
    }

    private fun strToIntSub(index: Int, str: String): Int {
        return str.substring(index, str.length).toInt()
    }

    private fun intToStrFormat(digit: String, number: Int): String {
        val format = "%0" + digit + "d"
        return String.format(format, number)
    }
}