package io.github.jinsuseongchan.domain.restaurant.service

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import io.github.jinsuseongchan.domain.restaurant.domain.Menu
import io.github.jinsuseongchan.domain.restaurant.domain.Money
import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import io.github.jinsuseongchan.domain.restaurant.repository.CategoryRepository
import io.github.jinsuseongchan.domain.restaurant.repository.RestaurantRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class MenuServiceTest @Autowired constructor(
    val menuService: MenuService,
    val categoryRepository: CategoryRepository,
    val restaurantRepository: RestaurantRepository
) {

    @Test
    @DisplayName("메뉴 정보를 저장할 수 있다")
    fun saveMenuTest() {
        // given
        val category = categoryRepository.save(Category(name = "테스트 카테고리"))
        val restaurant = restaurantRepository.save(
            Restaurant(
                name = "테스트 식당",
                address = "테스트 주소",
                telephoneNumber = "021113333",
                categoryId = category
            )
        )
        val menu = Menu(
            name = "테스트 메뉴",
            price = Money(money = 10000),
            restaurantId = restaurant
        )

        // when
        val savedMenu = menuService.saveMenu(menu)

        // then
        assertThat(savedMenu).isSameAs(menu)
    }

    @Test
    @DisplayName("메뉴 정보를 조회할 수 있다")
    fun getMenuTest() {
        // given
        val category = categoryRepository.save(Category(name = "테스트 카테고리"))
        val restaurant = restaurantRepository.save(
            Restaurant(
                name = "테스트 식당",
                address = "테스트 주소",
                telephoneNumber = "021113333",
                categoryId = category
            )
        )
        val menu = menuService.saveMenu(Menu(
            name = "테스트 메뉴",
            price = Money(money = 10000),
            restaurantId = restaurant)
        )

        // when
        val foundMenu = menuService.getMenuByMenuId(menu.id ?: 0)

        // then
        assertThat(foundMenu).isEqualTo(menu)
    }
}