package com.spring.starter.service.impl

import com.spring.starter.model.general.PaginationRequest
import com.spring.starter.model.person.CreatePersonRequest
import com.spring.starter.model.person.PersonResponse
import com.spring.starter.model.person.UpdatePersonRequest
import com.spring.starter.service.PersonService

class PersonSeviceImpl: PersonService {

    override fun create(createRequest: CreatePersonRequest): PersonResponse {
        TODO("Not yet implemented")
    }

    override fun get(idNumber: String): PersonResponse {
        TODO("Not yet implemented")
    }

    override fun update(idNumber: String, updateRequest: UpdatePersonRequest): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(idNumber: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun list(listRequest: PaginationRequest): List<PersonResponse> {
        TODO("Not yet implemented")
    }
}