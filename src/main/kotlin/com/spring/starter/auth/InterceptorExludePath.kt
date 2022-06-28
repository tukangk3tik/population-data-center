package com.spring.starter.auth

import com.spring.starter.utils.apiUrl

val jwtExcludePath : List<String> = listOf(
    "",
    "/api",
    apiUrl,
    "${apiUrl}/auth/**"
)