package com.journaler.repository

import com.journaler.api.security.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String> {
    fun findOneByEmail(email: String): User?
}