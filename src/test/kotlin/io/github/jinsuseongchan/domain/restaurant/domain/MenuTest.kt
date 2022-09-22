package io.github.jinsuseongchan.domain.restaurant.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("메뉴 테스트")
class MenuTest {

    @Test
    @DisplayName("id가 같으면 같은 메뉴이다")
    fun equalIdIsEqualMenu() {
        // given
        val menu1 = Menu(
            name = "테스트 메뉴1",
            price = Money(money = 10000),
            restaurantId = Restaurant(
                name = "테스트 식당",
                address = "테스트 주소",
                telephoneNumber = "021112222",
                categoryId = Category(name = "테스트 카테고리")
            )
        )
        val menu2 = Menu(
            name = "테스트 메뉴2",
            price = Money(money = 20000),
            restaurantId = Restaurant(
                name = "테스트 식당",
                address = "테스트 주소",
                telephoneNumber = "021112222",
                categoryId = Category(name = "테스트 카테고리")
            )
        )

        // when
        menu1.id = 1L
        menu2.id = 1L

        // then
        assertThat(menu1).isEqualTo(menu2)
    }
}