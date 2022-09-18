package io.github.jinsuseongchan.domain.restaurant.repository

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.dao.InvalidDataAccessApiUsageException
import org.springframework.data.repository.findByIdOrNull

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@DataJpaTest(showSql = true)
class RestaurantRepositoryTest @Autowired constructor(
    val restaurantRepository: RestaurantRepository,
    val categoryRepository: CategoryRepository
) {

    @Nested
    @DisplayName("식당 정보 저장 테스트")
    inner class RestaurantSaveTest {

        @Test
        @DisplayName("식당 정보를 저장할 수 있다")
        fun succeedSavingRestaurantInfo() {
            // given
            val category = categoryRepository.save(Category(name = "테스트 카테고리"))
            val restaurant = Restaurant(
                name = "식당 테스트",
                address = "주소 테스트",
                telephoneNumber = "021234567",
                categoryId = category
            )

            // when
            val savedRestaurant = restaurantRepository.save(restaurant)

            // then
            assertThat(savedRestaurant).isSameAs(restaurant)
        }

        @Test
        @DisplayName("잘못된 카테고리로는 식당 정보를 저장할 수 없다")
        fun failSavingCauseByNotExistCategory() {
            // given
            val restaurant = Restaurant(
                name = "식당 테스트",
                address = "주소 테스트",
                telephoneNumber = "021111323",
                categoryId = Category("저장되지 않은 카테고리")
            )

            // when
            // then
            assertThatExceptionOfType(InvalidDataAccessApiUsageException::class.java)
                .isThrownBy { restaurantRepository.save(restaurant) }
        }
    }

    @Nested
    @DisplayName("식당 정보 조회 테스트")
    inner class RestaurantLookUpTest {

        @Test
        @DisplayName("식당 아이디로 식당을 조회할 수 있다")
        fun succeedLookingUpRestaurant() {
            //given
            val category = categoryRepository.save(Category(name = "테스트 카테고리"))
            val restaurant = restaurantRepository.save(
                Restaurant(
                    name = "식당 테스트",
                    address = "테스트 주소",
                    telephoneNumber = "0213234345",
                    categoryId = category
                )
            )
            val restaurantId = restaurant.id?:1L

            // when
            val foundRestaurant = restaurantRepository.findByIdOrNull(restaurantId)

            // then
            assertThat(foundRestaurant).isSameAs(restaurant)
        }

        @Test
        @DisplayName("카테고리에 해당하는 식당 리스트를 얻을 수 있다")
        fun succeedGetRestaurantListByCategory() {
            // given
            val category = categoryRepository.save(Category(name = "테스트 카테고리"))
            val restaurantList = listOf(
                Restaurant(
                    name = "식당 테스트1",
                    address = "테스트 주소1",
                    telephoneNumber = "021111111",
                    categoryId = category
                ),
                Restaurant(
                    name = "식당 테스트2",
                    address = "테스트 주소2",
                    telephoneNumber = "022222222",
                    categoryId = category
                ),
                Restaurant(
                    name = "식당 테스트3",
                    address = "테스트 주소3",
                    telephoneNumber = "023333333",
                    categoryId = category
                )
            )
            restaurantList.map { restaurantRepository.save(it) }

            // when
            val foundRestaurantListByCategory = restaurantRepository.findByCategoryId(category)

            // then
            assertThat(foundRestaurantListByCategory).isEqualTo(restaurantList)
        }

        @Test
        @DisplayName("없는 식당 아이디로 조회하면 null을 얻는다")
        fun failLookingUpRestaurantCauseNotExistId() {
            // given
            val id = 10L

            // when
            val foundRestaurant = restaurantRepository.findByIdOrNull(id)

            // then
            assertThat(foundRestaurant).isNull()
        }
    }
}
