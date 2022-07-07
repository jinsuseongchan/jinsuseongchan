package io.github.baesa.restaurant.repository;

import io.github.baesa.restaurant.domain.Category
import io.github.baesa.restaurant.domain.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepository : JpaRepository<Restaurant, Long> {
    fun findByCategoryId(categoryId: Category): List<Restaurant>
}