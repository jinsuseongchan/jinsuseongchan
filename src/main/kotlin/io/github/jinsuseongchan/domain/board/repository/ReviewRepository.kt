package io.github.jinsuseongchan.domain.board.repository;

import io.github.jinsuseongchan.domain.board.domain.Review
import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {
    fun findByRestaurantId(restaurantId: Restaurant): List<Review>
}
