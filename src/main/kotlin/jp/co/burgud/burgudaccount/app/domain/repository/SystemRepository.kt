package jp.co.burgud.burgudaccount.app.domain.repository

interface SystemRepository {
    fun getPageCount(): Int

    fun updatePageCount(count: Int)
}