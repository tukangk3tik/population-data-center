package com.spring.starter.auth

import com.spring.starter.utils.apiUrl
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Component
class InterceptorConfiguration(val jwtInterceptor: JwtInterceptor): WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        super.addInterceptors(registry)
        registry
            .addWebRequestInterceptor(jwtInterceptor)
            .excludePathPatterns(
                "",
                "/api",
                apiUrl,
                "${apiUrl}/auth/**"
            )
    }

}