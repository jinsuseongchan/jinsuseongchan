package io.github.baesa.domain.restaurant.repository;

import io.github.baesa.domain.restaurant.domain.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}
