package io.github.baesa.domain.board.repository;

import io.github.baesa.domain.board.domain.Review
import io.github.baesa.domain.restaurant.domain.Restaurant
import io.github.baesa.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {
    fun findByUserId(userId: User): List<Review>
    fun findByRestaurantId(restaurantId: Restaurant): List<Review>
}