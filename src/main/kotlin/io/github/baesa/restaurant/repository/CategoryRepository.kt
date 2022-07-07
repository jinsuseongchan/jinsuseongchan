package io.github.baesa.restaurant.repository;

import io.github.baesa.restaurant.domain.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}