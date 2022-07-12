package io.github.baesa.domain.user.repository;

import io.github.baesa.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, UUID> {
}
