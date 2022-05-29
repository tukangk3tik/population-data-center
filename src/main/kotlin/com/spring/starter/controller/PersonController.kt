package com.spring.starter.controller

import com.spring.starter.model.general.pagination.PaginationRequest
import com.spring.starter.model.general.WebResponse
import com.spring.starter.model.general.pagination.PaginationResultBuilder
import com.spring.starter.model.general.pagination.PaginationMetadata
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
    ): WebResponse<PaginationResultBuilder<PersonResponse>> {
        val request = PaginationRequest(page = page, size = size)
        val response = personService.list(request)
        val paginationBuilder = PaginationResultBuilder(
            _metadata = PaginationMetadata(page = page, perPage = size, total = response.size),
            records = response
        )

        return WebResponse(
            status = "success",
            message = "OK",
            data = paginationBuilder
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
    fun createPerson(@RequestBody body: CreatePersonRequest): WebResponse<PersonResponse> {
        val personResponse = personService.create(body)
        return WebResponse(
            status = "success",
            message = "OK",
            data = personResponse
        )
    }

}