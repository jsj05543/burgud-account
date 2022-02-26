package jp.co.burgud.burgudaccount.app.web.form


import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class FacilityForm(
    val facilityKbn: String,
    val facilityName: String?,
)