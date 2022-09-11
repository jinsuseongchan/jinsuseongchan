package io.github.jinsuseongchan.domain.restaurant.repository

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.dao.InvalidDataAccessApiUsageException

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class RestaurantRepositoryTest {

    @DataJpaTest(showSql = true)
    @DisplayName("식당 정보 저장 테스트")
    class RestaurantSaveTest @Autowired constructor(
        val restaurantRepository: RestaurantRepository,
        val categoryRepository: CategoryRepository
    ) {
        val category = Category(name = "테스트 카테고리")

        @Test
        @DisplayName("식당 정보를 저장할 수 있다")
        fun succeedSavingRestaurantInfo() {
            // given
            val testCategory = categoryRepository.save(category)

            val restaurant = Restaurant(
                name = "식당 테스트",
                address = "주소 테스트",
                telephoneNumber = "021234567",
                categoryId = testCategory
            )

            // when
            val savedRestaurant: Restaurant = restaurantRepository.save(restaurant)

            // then
            assertThat(restaurant).isSameAs(savedRestaurant)
        }

        @Test
        @DisplayName("잘못된 카테고리로는 식당 정보를 저장할 수 없다")
        fun failSavingCauseByNotExistCategory() {
            // given
            val notExistCategory = Category(name = "존재하지 않는 카테고리")
            val restaurant = Restaurant(
                name = "식당 테스트",
                address = "주소 테스트",
                telephoneNumber = "021111323",
                categoryId = notExistCategory
            )

            // when
            // then
            assertThatExceptionOfType(InvalidDataAccessApiUsageException::class.java)
                .isThrownBy { restaurantRepository.save(restaurant) }
        }
    }
}