package io.github.jinsuseongchan.domain.user.repository

import io.github.jinsuseongchan.domain.user.domain.User
import io.github.jinsuseongchan.global.domain.Authority
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDate

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("dev")
class UserRepositoryTest {

    @DataJpaTest(showSql = true)
    @DisplayName("유저 정보 저장 테스트")
    class UserSaveTest @Autowired constructor(val userRepository: UserRepository) {
        @Test
        @DisplayName("모든 정보를 가진 유저 정보를 저장할 수 있다.")
        fun successAllInfo() {
            // given
            val user: User = User(
                username = "test",
                password = "test",
                nickName = "allInfoUser",
                gender = "남자",
                birthday = LocalDate.now(),
                authority = Authority.USER
            )

            // when
            val savedUser: User = userRepository.save(user)

            // then
            Assertions.assertThat(user).isSameAs(savedUser)
        }

        @Test
        @DisplayName("nullable 정보를 null로 가진 유저 정보를 저장할 수 있다.")
        fun successHaveNullableInfo() {
            // given
            val user: User = User(
                username = "test",
                password = "test",
                nickName = "nullableInfoUser",
                authority = Authority.USER
            )

            // when
            val savedUser: User = userRepository.save(user)

            // then
            Assertions.assertThat(user).isSameAs(savedUser)
            Assertions.assertThat(user.gender).isSameAs(savedUser.gender).isNull()
        }

        @Test
        @DisplayName("아이디가 중복되면 유저 정보를 저장할 수 없다.")
        fun failWhenDuplicateUsername() {
            // given
            val user: User = User(
                username = "test",
                password = "test",
                nickName = "User",
                gender = "남자",
                birthday = LocalDate.now(),
                authority = Authority.USER
            )

            val duplicateUser: User = User(
                username = "test",
                password = "test1234",
                nickName = "duplicateUser",
                authority = Authority.USER
            )

            // when
            val savedUser: User = userRepository.save(user)

            // then
            Assertions
                .assertThatExceptionOfType(DataIntegrityViolationException::class.java)
                .isThrownBy { userRepository.save(duplicateUser) }
        }
    }

}
