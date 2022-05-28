package com.spring.starter.service

import com.spring.starter.model.general.PaginationRequest
import com.spring.starter.model.person.CreatePersonRequest
import com.spring.starter.model.person.PersonResponse
import com.spring.starter.model.person.UpdatePersonRequest

interface PersonService {
    fun create(createRequest: CreatePersonRequest): PersonResponse

    fun get(idNumber: String): PersonResponse

    fun update(idNumber: String, updateRequest: UpdatePersonRequest): PersonResponse

    fun delete(idNumber: String)

    fun list(listRequest: PaginationRequest): List<PersonResponse>
}
