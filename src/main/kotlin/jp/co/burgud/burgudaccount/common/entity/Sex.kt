package jp.co.burgud.burgudaccount.common.entity

import java.util.*
import kotlin.collections.LinkedHashMap


enum class Sex(private val value: String, private val label: String) {
    MAN("1", "男性"),
    WOMAN("2", "女性");

    companion object{
        fun asMap(): Map<String, String> {
            val map: MutableMap<String, String> = LinkedHashMap()
            Arrays.stream(values()).forEach { e -> map.put(e.value, e.label) }
            return map
        }
    }
}