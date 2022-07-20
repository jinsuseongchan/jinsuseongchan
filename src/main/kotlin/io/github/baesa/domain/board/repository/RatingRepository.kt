package io.github.baesa.domain.board.repository;

import io.github.baesa.domain.board.domain.Rating
import org.springframework.data.jpa.repository.JpaRepository

interface RatingRepository : JpaRepository<Rating, Long> {
}
