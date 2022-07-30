package io.github.jinsuseongchan.domain.board.repository;

import io.github.jinsuseongchan.domain.board.domain.Rating
import org.springframework.data.jpa.repository.JpaRepository

interface RatingRepository : JpaRepository<Rating, Long> {
}
