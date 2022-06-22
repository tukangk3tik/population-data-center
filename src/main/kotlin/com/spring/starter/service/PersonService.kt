package com.spring.starter.service

import com.spring.starter.entity.Person
import com.spring.starter.model.general.pagination.PaginationRequest
import com.spring.starter.model.person.CreatePersonRequest
import com.spring.starter.model.person.PersonResponse
import com.spring.starter.model.person.UpdatePersonRequest

interface PersonService {
    fun create(createRequest: CreatePersonRequest): PersonResponse

    fun get(idNumber: String): PersonResponse

    fun update(idNumber: String, updateRequest: UpdatePersonRequest): PersonResponse

    fun delete(idNumber: String)

    fun list(listRequest: PaginationRequest): List<PersonResponse>

    fun convertPersonToResponse(person: Person): PersonResponse
}
