package com.spring.starter.auth

import com.spring.starter.error.UnauthorizedException
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor

@Component
class JwtInterceptor: WebRequestInterceptor {

    override fun preHandle(request: WebRequest) {
        val authHeader = request.getHeader("Authorization") ?: throw UnauthorizedException()
        val token = authHeader.trim().split("Bearer ")[1]
        JwtProvider.validateToken(token)
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        //do nothing
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        //do nothing
    }


}