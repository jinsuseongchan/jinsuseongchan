package io.github.jinsuseongchan.domain.restaurant.repository;

import io.github.jinsuseongchan.domain.restaurant.domain.Menu
import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<Menu, Long> {
    fun findByRestaurantId(restaurantId: Restaurant): List<Menu>
}
