package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.app.domain.entity.Facility

interface FacilityRepository {
    fun getAllFacility(): List<Facility>

    fun getFacilityKbnList(): List<String>

    fun update(facilityList: List<Facility>, loginUser: String)

    fun create(facility: Facility)
}