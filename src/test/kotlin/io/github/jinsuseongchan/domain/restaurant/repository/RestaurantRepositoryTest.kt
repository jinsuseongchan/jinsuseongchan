package io.github.jinsuseongchan.domain.restaurant.repository

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import org.assertj.core.api.Assertions.assertThat
import org.junit.BeforeClass
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class RestaurantRepositoryTest {

    @DataJpaTest(showSql = true)
    @DisplayName("식당 정보 저장 테스트")
    class RestaurantSaveTest @Autowired constructor(
        val restaurantRepository: RestaurantRepository,
        val categoryRepository: CategoryRepository
    ) {

        var category: Category = Category(name = "테스트 카테고리")
        lateinit var testCategory: Category


        @BeforeClass
        fun beforeTest() {
            testCategory = categoryRepository.save(category)
        }

        @Test
        @DisplayName("식당 정보를 저장할 수 있다")
        fun succeedSavingRestaurantInfo() {
            // given
            val restaurant = Restaurant(
                name = "식당 테스트",
                address = "주소 테스트",
                telephoneNumber = "021234567",
                categoryId = category
            )

            // when
            val savedRestaurant: Restaurant = restaurantRepository.save(restaurant)

            // then
            assertThat(restaurant).isSameAs(savedRestaurant)
        }
    }
}