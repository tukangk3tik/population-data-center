package com.spring.starter.controller

import com.spring.starter.error.*
import com.spring.starter.model.general.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String?> {
       return WebResponse(
           status = "fail",
           message = "BAD REQUEST",
           data = constraintViolationException.message
       )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String> {
        return WebResponse(
            status = "fail",
            message = "NOT FOUND",
            data = "Not Found"
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorizedException(unauthorizedException: UnauthorizedException): WebResponse<String> {
        return WebResponse(
            status = "fail",
            message = "UNAUTHORIZED",
            data = "Please put your token"
        )
    }

    @ExceptionHandler(value = [AlreadyExitsException::class])
    fun alreadyExistsException(alreadyExitsException: AlreadyExitsException): WebResponse<String> {
        return WebResponse(
            status = "fail",
            message = "NOT AVAILABLE",
            data = "Insert fail. Data is already exists"
        )
    }

    @ExceptionHandler(value = [UserNotFoundException::class])
    fun userNotFoundException(userNotFoundException: UserNotFoundException): WebResponse<String> {
        return WebResponse(
            status = "fail",
            message = "LOGIN FAIL",
            data = "User not found"
        )
    }

    @ExceptionHandler(value = [LoginFailException::class])
    fun loginFailException(loginFailException: LoginFailException): WebResponse<String> {
        return WebResponse(
            status = "fail",
            message = "LOGIN FAIL",
            data = "Email or password are invalid"
        )
    }

    @ExceptionHandler(value = [TokenInvalidException::class])
    fun tokenInvalidException(tokenInvalidException: TokenInvalidException): WebResponse<String> {
        return WebResponse(
            status = "fail",
            message = "TOKEN ERROR",
            data = "Token is invalid or expired"
        )
    }
}