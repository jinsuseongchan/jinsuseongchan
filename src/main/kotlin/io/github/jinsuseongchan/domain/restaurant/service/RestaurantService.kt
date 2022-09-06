package io.github.jinsuseongchan.domain.restaurant.service

import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import io.github.jinsuseongchan.domain.restaurant.repository.RestaurantRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class RestaurantService (val restaurantRepository: RestaurantRepository) {
    fun loadRestaurantByRestaurantId(restaurantId: Long): Optional<Restaurant> {
        val restaurant = restaurantRepository.findById(restaurantId)
        return restaurant
    }
}
