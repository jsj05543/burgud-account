package jp.co.burgud.burgudaccount.app.domain.entity


enum class Sex(private val value: String, private val label: String) {
    MAN("1", "男性"),
    WOMAN("2", "女性");

    companion object {
        fun asMap(): Map<String, String> {
            return values().map { it.value to it.label }.toMap()
        }
    }
}