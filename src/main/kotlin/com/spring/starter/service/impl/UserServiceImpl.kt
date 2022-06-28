package com.spring.starter.service.impl

import com.spring.starter.auth.JwtProvider
import com.spring.starter.error.LoginFailException
import com.spring.starter.error.UserNotFoundException
import com.spring.starter.model.user.LoginRequest
import com.spring.starter.model.user.LoginResponse
import com.spring.starter.repository.UserRepository
import com.spring.starter.service.UserService
import com.spring.starter.validation.ValidationUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    @Autowired private val userRepository: UserRepository,
    private val validationUtils: ValidationUtils
): UserService {

    override fun login(loginRequest: LoginRequest): LoginResponse {
        validationUtils.validate(loginRequest)
        val getUser = userRepository.findByEmail(loginRequest.email!!) ?: throw UserNotFoundException()

        if (!getUser.comparePassword(loginRequest.password!!)) throw LoginFailException()
        val jwt = JwtProvider.generateToken(getUser.id!!)

        return LoginResponse(
            tokenType = "",
            expiresInt = jwt["expiresIn"] as Long,
            accessToken = jwt["token"].toString()
        )
    }

}