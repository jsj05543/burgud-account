package jp.co.burgud.burgudaccount.app.domain.repository

import jp.co.burgud.burgudaccount.common.entity.Country
import jp.co.burgud.burgudaccount.common.entity.Facility

interface FacilityRepository {
    fun getAllFacility(): List<Facility>

    fun getFacility(): List<Facility>
}