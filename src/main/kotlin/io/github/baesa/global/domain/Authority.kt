package io.github.baesa.global.domain

enum class Authority(val role: String, val index: Int) {
    ADMIN("ROLE_ADMIN", 0),
    MANAGER("ROLE_MANAGER", 1),
    USER("ROLE_USER", 2)
}
