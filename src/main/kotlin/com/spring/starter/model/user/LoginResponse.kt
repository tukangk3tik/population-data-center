package com.spring.starter.model.user

data class LoginResponse(
    val tokenType: String,
    val expiresInt: Long,
    val accessToken: String,
)
