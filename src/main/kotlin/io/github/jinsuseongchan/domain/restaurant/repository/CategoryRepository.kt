package io.github.jinsuseongchan.domain.restaurant.repository;

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}
