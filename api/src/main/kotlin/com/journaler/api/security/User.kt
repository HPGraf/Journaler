package com.journaler.api.security

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotBlank

@Entity
@Table(name = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
open class User(
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "varchar (36)")
        open var id: String = "",
        @Column(unique = true, nullable = false)
        @NotNull
        @Email
        open var email: String = "",
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @NotBlank
        open var pwd: String = "",
        @NotBlank
        open var firstName: String = "",
        @NotBlank
        open var lastName: String = "",
        open var roles: String = "",
        open var enabled: Boolean = true,
        open var accountNonExpired: Boolean = true,
        open var accountNonLocked: Boolean = true,
        open var credentialsNonExpired: Boolean = true,
        @CreationTimestamp
        open var created: Date = Date(),
        @UpdateTimestamp
        open var modified: Date = Date()
) : UserDetails {
    constructor() : this("", "", "", "", "", "", true, true, true, true, Date(), Date())

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()
        roles
                .split(",")
                .forEach { it -> authorities.add(SimpleGrantedAuthority(it.trim())) }
        return authorities
    }

    override fun isEnabled(): Boolean {
        return enabled
    }

    override fun getUsername(): String {
        return email
    }

    override fun isCredentialsNonExpired(): Boolean {
        return credentialsNonExpired
    }

    override fun getPassword(): String {
        return pwd
    }

    override fun isAccountNonExpired(): Boolean {
        return accountNonExpired
    }

    override fun isAccountNonLocked(): Boolean {
        return accountNonLocked
    }
}