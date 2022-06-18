package com.spring.starter.service

import com.spring.starter.model.user.LoginRequest
import com.spring.starter.model.user.LoginResponse


interface UserService {

    fun login(loginRequest: LoginRequest): LoginResponse

}