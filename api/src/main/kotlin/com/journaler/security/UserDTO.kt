package com.journaler.security

data class UserDTO (
        var email: String,
        var password: String,
        var firstName: String,
        var lastName: String
) {
    constructor(): this("","","","")
}