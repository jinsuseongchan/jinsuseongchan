package io.github.jinsuseongchan.domain.restaurant.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("카테고리 테스트")
class CategoryTest {

    @Test
    @DisplayName("id가 같으면 같은 카테고리이다")
    fun equalIdIsEqualCategory() {
        // given
        val category1 = Category(name = "테스트 카테고리1")
        val category2 = Category(name = "테스트 카테고리2")

        // when
        category1.id = 1L
        category2.id = 1L

        // then
        assertThat(category1).isEqualTo(category2)
    }
}
