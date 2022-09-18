package io.github.jinsuseongchan.domain.restaurant.service

import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import io.github.jinsuseongchan.domain.restaurant.repository.RestaurantRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class RestaurantService(val restaurantRepository: RestaurantRepository) {

    fun saveRestaurant(restaurant: Restaurant): Restaurant {
        return restaurantRepository.save(restaurant)
    }

    fun getRestaurantByRestaurantId(restaurantId: Long): Restaurant {
        return restaurantRepository.findByIdOrNull(restaurantId) ?: throw Exception("에러")
    }
}
