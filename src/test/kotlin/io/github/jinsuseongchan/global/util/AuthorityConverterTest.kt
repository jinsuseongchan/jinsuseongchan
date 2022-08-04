package io.github.jinsuseongchan.global.util

import io.github.jinsuseongchan.global.config.Authority
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AuthorityConverterTest {
    @Test
    fun convertToDBColumnTest() {
        // given
        val authorityConverter: AuthorityConverter = AuthorityConverter()
        val auth: Authority = Authority.USER

        // when
        val index: Int = authorityConverter.convertToDatabaseColumn(auth)

        // then
        Assertions.assertThat(index).isSameAs(2)
    }

    @Test
    fun convertToEntityAttributeTest() {
        // given
        val authorityConverter: AuthorityConverter = AuthorityConverter()

        // when
        val authority: Authority = authorityConverter.convertToEntityAttribute(1)

        // then
        Assertions.assertThat(authority).isSameAs(Authority.MANAGER)
    }
}
