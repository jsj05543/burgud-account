package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.common.entity.Pref
import jp.co.burgud.burgudaccount.common.entity.User
import java.time.LocalDateTime

internal data class PrefRecord(
    val prefCode: Int,
    val prefName: String
)

internal fun PrefRecord.toEntity(): Pref =
    Pref(
        prefCode = prefCode,
        prefName = prefName
    )