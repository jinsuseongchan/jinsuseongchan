package io.github.jinsuseongchan.domain.board.controller

import io.github.jinsuseongchan.domain.board.domain.Review
import io.github.jinsuseongchan.domain.board.service.ReviewService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/api/review")
class ReviewController {

    @Autowired
    lateinit var reviewService: ReviewService

    @GetMapping("/{restaurantId}")
    fun getReviewByRestaurant(@PathVariable restaurantId: Long): ResponseEntity<List<Review>> {
        val reviewList = reviewService.getReviewsByRestaurant(restaurantId);
        return ResponseEntity(reviewList, HttpStatus.OK)
    }
}