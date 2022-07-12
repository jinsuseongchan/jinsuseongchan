package io.github.baesa.domain.user.repository;

import io.github.baesa.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}
