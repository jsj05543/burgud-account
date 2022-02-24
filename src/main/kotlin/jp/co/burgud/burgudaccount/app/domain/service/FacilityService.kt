package jp.co.burgud.burgudaccount.app.domain.service

import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import org.springframework.stereotype.Service

@Service
class FacilityService(
    private val facilityRepository: FacilityRepository
) {
    fun getFacilityKbnList(): List<String> {
        return facilityRepository.getFacilityKbnList()
    }
}