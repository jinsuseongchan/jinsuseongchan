package io.github.jinsuseongchan.domain.board.service

import io.github.jinsuseongchan.domain.board.domain.Review
import io.github.jinsuseongchan.domain.board.repository.ReviewRepository
import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import io.github.jinsuseongchan.domain.restaurant.repository.RestaurantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReviewService(
    val reviewRepository: ReviewRepository,
    val restaurantRepository: RestaurantRepository) {

    fun createReview(review: Review): Review {
        return reviewRepository.save(review)
    }

    fun getReviewsByRestaurant(restaurantId: Long): List<Review> {
        val restaurant: Restaurant = restaurantRepository.findById(restaurantId).get()
        return reviewRepository.findByRestaurantId(restaurant)
    }
}