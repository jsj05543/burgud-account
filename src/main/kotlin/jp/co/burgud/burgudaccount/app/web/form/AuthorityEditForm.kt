package jp.co.burgud.burgudaccount.app.web.form


import jp.co.burgud.burgudaccount.app.domain.entity.Authority
import lombok.NoArgsConstructor
import org.springframework.lang.NonNull
import javax.validation.Valid

@NoArgsConstructor
data class AuthorityEditForm(
    @field:[Valid NonNull]
    var authorityList: List<Authority> = mutableListOf()
)