package io.github.jinsuseongchan.domain.restaurant.repository

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import io.github.jinsuseongchan.domain.restaurant.domain.Menu
import io.github.jinsuseongchan.domain.restaurant.domain.Money
import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.dao.InvalidDataAccessApiUsageException
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class MenuRepositoryTest @Autowired constructor(
    val categoryRepository: CategoryRepository,
    val restaurantRepository: RestaurantRepository,
    val menuRepository: MenuRepository
) {

    @Nested
    @DisplayName("메뉴 정보 저장 테스트")
    inner class MenuSaveTest {

        @Test
        @DisplayName("메뉴 정보를 저장할 수 있다")
        fun succeedSavingMenuInfo() {
            // given
            val category = categoryRepository.save(Category(name = "테스트 카테고리"))
            val restaurant = restaurantRepository.save(
                Restaurant(
                    name = "식당 테스트",
                    address = "주소 테스트",
                    telephoneNumber = "021112222",
                    categoryId = category
                )
            )
            val menu = Menu(
                name = "테스트 메뉴",
                price = Money(money = 10000),
                restaurantId = restaurant
            )

            // when
            val savedMenu = menuRepository.save(menu)

            // then
            assertThat(savedMenu).isSameAs(menu)
        }

        @Test
        @DisplayName("잘못된 식당으로는 메뉴 정보를 저장할 수 없다")
        fun failSavingCauseByNotExistRestaurant() {
            // given
            val menu = Menu(
                name = "테스트 메뉴",
                price = Money(money = 10000),
                restaurantId = Restaurant(
                    name = "저장되지 않은 식당",
                    address = "주소",
                    telephoneNumber = "021113333",
                    categoryId = Category(name = "저장되지 않는 카테고리")
                )
            )

            // when
            // then
            assertThatExceptionOfType(InvalidDataAccessApiUsageException::class.java)
                .isThrownBy { menuRepository.save(menu) }
        }
    }

    @Nested
    @DisplayName("메뉴 정보 조회 테스트")
    inner class MenuLookUpTest() {

        @Test
        @DisplayName("메뉴 아이디로 메뉴를 조회할 수 있다")
        fun succeedLookingUpMenu() {
            // given
            val category = categoryRepository.save(Category(name = "테스트 카테고리"))
            val restaurant = restaurantRepository.save(
                Restaurant(
                    name = "식당 테스트",
                    address = "테스트 주소",
                    telephoneNumber = "0213234345",
                    categoryId = category
                )
            )
            val menu = menuRepository.save(
                Menu(
                    name = "테스트 메뉴",
                    price = Money(money = 10000),
                    restaurantId = restaurant
                )
            )
            val menuId = menu.id?:1L

            // when
            val foundMenu = menuRepository.findByIdOrNull(menuId)

            // then
            assertThat(foundMenu).isSameAs(menu)
        }
    }
}
