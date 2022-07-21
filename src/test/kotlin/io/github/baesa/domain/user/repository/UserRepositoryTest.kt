package io.github.baesa.domain.user.repository

import io.github.baesa.domain.user.domain.User
import io.github.baesa.global.domain.Authority
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
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
                name = "allInfo",
                gender = "남자",
                birthday = LocalDate.now(),
                phone = "01012345678",
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
                name = "nullableInfo",
                authority = Authority.USER
            )

            // when
            val savedUser: User = userRepository.save(user)

            // then
            Assertions.assertThat(user).isSameAs(savedUser)
            Assertions.assertThat(user.gender).isSameAs(savedUser.gender).isNull()
        }
    }

}
