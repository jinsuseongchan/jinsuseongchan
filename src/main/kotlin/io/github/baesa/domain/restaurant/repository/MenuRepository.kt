package io.github.baesa.domain.restaurant.repository;

import io.github.baesa.domain.restaurant.domain.Menu
import io.github.baesa.domain.restaurant.domain.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<Menu, Long> {
    fun findByRestaurantId(restaurantId: Restaurant): List<Menu>
}
