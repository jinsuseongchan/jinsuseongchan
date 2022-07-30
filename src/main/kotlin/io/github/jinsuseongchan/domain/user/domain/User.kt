package io.github.jinsuseongchan.domain.user.domain

import io.github.jinsuseongchan.global.domain.Authority
import io.github.jinsuseongchan.global.util.AuthorityConverter
import lombok.Getter
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "member")
class User(
    @Column(name = "username", nullable = false, length = 20, unique = true)
    var username: String,

    @Column(name = "password", nullable = false, length = 100)
    var password: String,

    @Column(name = "nick_name", nullable = false, length = 20, unique = true)
    var nickName: String,

    @Column(name = "gender")
    var gender: String? = null,

    @Column(name = "birthday")
    var birthday: LocalDate? = null,

    @Column(name = "authority", nullable = false)
    @Convert(converter = AuthorityConverter::class)
    var authority: Authority
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
