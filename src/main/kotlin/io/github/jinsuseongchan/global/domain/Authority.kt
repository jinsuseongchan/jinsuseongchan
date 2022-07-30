package io.github.jinsuseongchan.global.domain

import lombok.Getter

@Getter
enum class Authority(val role: String, val index: Int) {
    ADMIN("ROLE_ADMIN", 0),
    MANAGER("ROLE_MANAGER", 1),
    USER("ROLE_USER", 2)
}
