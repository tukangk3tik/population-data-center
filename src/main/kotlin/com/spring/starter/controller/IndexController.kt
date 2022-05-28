package com.spring.starter.controller

import com.spring.starter.model.general.WebResponse
import com.spring.starter.utils.apiUrl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

   @GetMapping(
       value = [apiUrl],
       produces = ["application/json"])
   fun index(): WebResponse<String> {
       return WebResponse(status = "success", message = "OK", data = "Population Data Center - API v1")
   }
}