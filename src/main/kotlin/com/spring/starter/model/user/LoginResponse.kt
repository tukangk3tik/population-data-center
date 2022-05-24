package com.spring.starter.model.user

data class LoginResponse(
    val tokenType: String,
    val expiresInt: Int,
    val accessToken: String,
)
