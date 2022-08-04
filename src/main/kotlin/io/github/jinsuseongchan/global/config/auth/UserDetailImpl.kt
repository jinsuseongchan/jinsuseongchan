package io.github.jinsuseongchan.global.config.auth

import io.github.jinsuseongchan.domain.user.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

class UserDetailImpl(private val user: User): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val roles: MutableCollection<GrantedAuthority> = ArrayList<GrantedAuthority>()
        roles.add(GrantedAuthority { user.authority.role })
        return roles
    }

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.username

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}
