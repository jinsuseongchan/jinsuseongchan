package io.github.jinsuseongchan.domain.user.repository;

import io.github.jinsuseongchan.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}
