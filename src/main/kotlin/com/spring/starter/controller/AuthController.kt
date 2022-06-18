package com.spring.starter.controller

import com.spring.starter.model.general.WebResponse
import com.spring.starter.model.user.LoginRequest
import com.spring.starter.model.user.LoginResponse
import com.spring.starter.service.UserService
import com.spring.starter.utils.apiUrl
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(val userService: UserService) {

    @PostMapping(
        value = ["${apiUrl}/auth/login"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun login(@RequestBody body: LoginRequest): WebResponse<LoginResponse> {
        val loginResponse = userService.login(body)
        return WebResponse(
            status = "success",
            message = "OK",
            data = loginResponse
        )
    }

}