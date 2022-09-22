package io.github.jinsuseongchan.domain.restaurant.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("식당 테스트")
class RestaurantTest {

    @Test
    @DisplayName("id가 같으면 같은 식당이다")
    fun equalIdIsEqualRestaurant() {
        // given
        val restaurant1 = Restaurant(
            name = "테스트 식당1",
            address = "테스트 주소1",
            telephoneNumber = "021112222",
            categoryId = Category(name = "테스트 카테고리")
        )
        val restaurant2 = Restaurant(
            name = "테스트 식당2",
            address = "테스트 주소2",
            telephoneNumber = "021112222",
            categoryId = Category(name = "테스트 카테고리")
        )

        // when
        restaurant1.id = 1L
        restaurant2.id = 1L

        // then
        assertThat(restaurant1).isEqualTo(restaurant2)
    }
}