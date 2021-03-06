package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.common.entity.Country
import jp.co.burgud.burgudaccount.common.entity.Facility
import lombok.NoArgsConstructor

@NoArgsConstructor
data class FacilityForm(
    val facilityList: List<Facility>
)