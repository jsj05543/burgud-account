package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.app.domain.entity.Facility
import lombok.NoArgsConstructor
import org.springframework.lang.NonNull
import javax.validation.Valid

@NoArgsConstructor
data class FacilityEditForm(
    var facilityList: List<Facility> = mutableListOf()
)