package com.journaler

import com.journaler.security.Admin
import com.journaler.security.Member
import com.journaler.service.UserService
import com.journaler.security.UserDTO
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.lang.RuntimeException

@RunWith(SpringRunner::class)
@SpringBootTest
class SecurityInitializationTest {
    @Autowired
    private lateinit var userService: UserService

    private val password = "123456"
    private val adminEmail = "admin@example.com"
    private val memberEmail = "member@example.com"

    @Test
    fun initAdmin() {
        try {
            val admin = userService.loadUserByUsername(adminEmail)
            if (admin is Admin) {
                println("Admin user exists: ${admin.id}")
            } else {
                Assert.fail("Admin is not an admin")
            }
        } catch (e: RuntimeException) {
            val toSave = UserDTO(
                    adminEmail,
                    password,
                    "admin first",
                    "admin last"
            )
            val saved = userService.saveAdmin(toSave)
            println("Admin user inserted: ${saved.id}")
        }
    }

    @Test
    fun iniMember() {
        try {
            val member = userService.loadUserByUsername(memberEmail)
            if (member is Member) {
                println("Member user exists: ${member.id}")
            } else {
                Assert.fail("Member is not a member")
            }
        } catch (e: RuntimeException) {
            val toSave = UserDTO(
                    memberEmail,
                    password,
                    "member first",
                    "member last"
            )
            val saved = userService.saveMember(toSave)
            println("Member user inserted: ${saved.id}")
        }
    }
}