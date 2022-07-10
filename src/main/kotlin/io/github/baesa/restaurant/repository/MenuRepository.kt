package io.github.baesa.restaurant.repository;

import io.github.baesa.restaurant.domain.Menu
import io.github.baesa.restaurant.domain.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<Menu, Long> {
    fun findByRestaurantId(restaurantId: Restaurant): List<Menu>
}
