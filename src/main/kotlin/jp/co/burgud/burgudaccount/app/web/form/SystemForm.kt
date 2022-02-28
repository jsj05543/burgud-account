package jp.co.burgud.burgudaccount.app.web.form


import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class SystemForm(
    val systemName: String?,
    val systemVersion: String?,
    val hostName: String?,
    val browser: String?,
    val iPAddress: String?,
    val pageCount: Int?,
    val unAccess: Boolean?,
    val userName: String?,
    val logoutAt: LocalDateTime?,
    val loginAt: LocalDateTime?
) {

}