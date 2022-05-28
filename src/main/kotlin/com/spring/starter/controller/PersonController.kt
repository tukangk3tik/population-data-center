package com.spring.starter.controller

import com.spring.starter.model.general.PaginationRequest
import com.spring.starter.model.general.WebResponse
import com.spring.starter.model.person.CreatePersonRequest
import com.spring.starter.model.person.PersonResponse
import com.spring.starter.service.PersonService
import com.spring.starter.utils.apiUrl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(val personService: PersonService) {

    @GetMapping(
        value = ["${apiUrl}/person"],
        produces = ["application/json"]
    )
    fun listPersons(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): WebResponse<List<PersonResponse>> {
        val request = PaginationRequest(page = page, size = size)
        val response = personService.list(request)
        return WebResponse(
            status = "success",
            message = "OK",
            data = response
        )
    }

    @GetMapping(
        value = ["${apiUrl}/person/{id}"],
        produces = ["application/json"]
    )
    fun getPerson(
        @PathVariable("id") id: String
    ): WebResponse<PersonResponse> {
        val response = personService.get(id)
        return WebResponse(
            status = "success",
            message = "OK",
            data = response
        )
    }

    @PostMapping(
        value = ["${apiUrl}/person"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreatePersonRequest): WebResponse<PersonResponse> {
        val personResponse = personService.create(body)
        return WebResponse(
            status = "success",
            message = "OK",
            data = personResponse
        )
    }

}