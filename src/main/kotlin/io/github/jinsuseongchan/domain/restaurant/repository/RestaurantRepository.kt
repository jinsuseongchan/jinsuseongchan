package io.github.jinsuseongchan.domain.restaurant.repository;

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepository : JpaRepository<Restaurant, Long> {
    fun findByCategoryId(categoryId: Category): List<Restaurant>
}
