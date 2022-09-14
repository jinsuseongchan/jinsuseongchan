package io.github.jinsuseongchan.domain.restaurant.service

import io.github.jinsuseongchan.domain.restaurant.domain.Category
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
class RestaurantServiceTest @Autowired constructor(
    val restaurantService: RestaurantService,
    val categoryRepository: CategoryRepository,
    val restaurantRepository: RestaurantRepository,
) {

    @Test
    @DisplayName("식당 id를 통해서 식당 정보를 얻어올 수 있다")
    fun getRestaurantByRestaurantIdTest() {
        // given
        val category = categoryRepository.save(Category(name = "테스트 카테고리"))
        val restaurant = restaurantRepository.save(Restaurant(
            name = "테스트 식당",
            address = "테스트 주소",
            telephoneNumber = "021112222",
            categoryId = category
        ))

        // when
        val resultRestaurant = restaurantService.getRestaurantByRestaurantId(restaurantId = restaurant.id?:0)

        // then
        assertThat(resultRestaurant).isEqualTo(restaurant)
    }
}