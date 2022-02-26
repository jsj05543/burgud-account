package jp.co.burgud.burgudaccount.app.web.form


data class PasswordForm(
    var userCd: String = "BU01",
    var passwordOld: String? = null,
    var passwordNew: String? = null,
    var passwordNewConfirm: String? = null
)