package jp.co.burgud.burgudaccount.app.web.controller

import jp.co.burgud.burgudaccount.app.domain.entity.City
import jp.co.burgud.burgudaccount.app.domain.entity.Pref
import jp.co.burgud.burgudaccount.app.domain.usecase.PrefAndCityUseCase
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
@RequestMapping
class UserAjaxController(
    private val prefAndCityUseCase: PrefAndCityUseCase
) {
    @PostMapping("/nutag")
    @ResponseBody
    fun setCitySelectBox(@RequestBody pref: Pref): List<City?>? {
        return prefAndCityUseCase.getCityByPrefCode(pref.prefCode)
    }
}