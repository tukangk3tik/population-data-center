package com.spring.starter.model.user

import javax.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank
    val email: String?,

    @field:NotBlank
    val password: String?
)