package com.spring.starter.controller

import com.spring.starter.utils.apiUrl
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
class IndexController {

   @GetMapping(
       value = [""],
       produces = [MediaType.TEXT_HTML_VALUE])
   fun index(): String = "Population Data Center - API v1"

    @GetMapping(
        value = ["/api"]
    )
    fun indexApi(response: HttpServletResponse) {
        response.sendRedirect(apiUrl)
    }

    @GetMapping(
        value = [apiUrl],
        produces = [MediaType.TEXT_HTML_VALUE])
    fun indexApiV1(): String = "Population Data Center - API v1"
}