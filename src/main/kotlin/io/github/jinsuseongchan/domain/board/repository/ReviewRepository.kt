package io.github.jinsuseongchan.domain.board.repository;

import io.github.jinsuseongchan.domain.board.domain.Review
import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import io.github.jinsuseongchan.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {
    fun findByUserId(userId: User): List<Review>
    fun findByRestaurantId(restaurantId: Restaurant): List<Review>
}
