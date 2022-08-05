package io.github.jinsuseongchan.domain.board.service

import io.github.jinsuseongchan.domain.board.domain.Review
import io.github.jinsuseongchan.domain.board.repository.ReviewRepository
import org.springframework.stereotype.Service

@Service
class ReviewService(val reviewRepository: ReviewRepository) {

    fun createReview(review: Review): Review {
        return reviewRepository.save(review)
    }
}