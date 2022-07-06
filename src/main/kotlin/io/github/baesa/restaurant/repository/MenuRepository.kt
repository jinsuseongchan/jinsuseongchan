package io.github.baesa.restaurant.repository;

import io.github.baesa.restaurant.domain.Menu
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<Menu, Long> {
}