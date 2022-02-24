package jp.co.burgud.burgudaccount.app.infra.mapper.record

import jp.co.burgud.burgudaccount.app.domain.entity.City

internal data class CityRecord(
    val prefCode: Int,
    val cityCode: Int,
    val cityName: String
)

internal fun CityRecord.toEntity(): City =
    City(
        prefCode = prefCode,
        cityCode = cityCode,
        cityName = cityName
    )