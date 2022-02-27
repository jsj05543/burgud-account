package jp.co.burgud.burgudaccount.app.domain.usecase

import jp.co.burgud.burgudaccount.app.domain.entity.Facility
import jp.co.burgud.burgudaccount.app.domain.repository.FacilityRepository
import jp.co.burgud.burgudaccount.app.domain.service.CreateKbnService
import jp.co.burgud.burgudaccount.app.domain.service.FacilityService
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class FacilityUseCase(
    private val facilityService: FacilityService,
    private val createKbnService: CreateKbnService,
    private val facilityRepository: FacilityRepository
) {
    companion object {
        private const val Facility_CODE = "FACILITY"
        private const val Facility_KBN_NEW = "FY00"
    }

    fun createNewCountryKbn(): String {
        val countryKbnList = facilityService.getFacilityKbnList()
        if (countryKbnList.isEmpty()) {
            return Facility_KBN_NEW
        }
        return createKbnService.getCodeVal(Facility_CODE) + createKbnService.getMaxKbn(countryKbnList)
    }

    fun getFacilityData(): Map<String, String> {
        return facilityRepository.getAllFacility().map {
            it.facilityKbn to it.facilityName
        }.toMap()
    }

    fun create(
        facilityKbn: String,
        facilityName: String?,
        loginUser: String
    ) {
        if (facilityName != null) {
            val facility = Facility(
                facilityKbn = facilityKbn,
                facilityName = facilityName,
                createUser = loginUser,
                createAt = LocalDateTime.now(),
                updateUser = null,
                updateAt = null
            )
            facilityRepository.create(facility)
        }
    }

    fun update(facilityList: List<Facility>, loginUser: String) {
        facilityRepository.update(
            facilityList = facilityList,
            loginUser = loginUser
        )
    }
}