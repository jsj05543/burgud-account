package jp.co.burgud.burgudaccount.app.infra.repository

import jp.co.burgud.burgudaccount.app.domain.repository.SystemRepository
import jp.co.burgud.burgudaccount.app.infra.mapper.SystemMapper
import org.springframework.stereotype.Repository

@Repository
internal class SystemRepositoryImpl(
    private val systemMapper: SystemMapper
) : SystemRepository {
    override fun getPageCount(): Int {
        return systemMapper.find();
    }

    override fun updatePageCount(count: Int) {
        systemMapper.update(count);
    }

}