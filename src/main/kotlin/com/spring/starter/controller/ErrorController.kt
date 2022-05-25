package com.spring.starter.controller

import com.spring.starter.error.NotFoundException
import com.spring.starter.error.UnauthorizedException
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
}