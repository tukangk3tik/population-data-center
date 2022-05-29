package com.spring.starter.service.impl

import com.spring.starter.entity.Person
import com.spring.starter.error.AlreadyExitsException
import com.spring.starter.error.NotFoundException
import com.spring.starter.model.general.pagination.PaginationRequest
import com.spring.starter.model.person.CreatePersonRequest
import com.spring.starter.model.person.PersonResponse
import com.spring.starter.model.person.UpdatePersonRequest
import com.spring.starter.repository.PersonRepository
import com.spring.starter.service.PersonService
import com.spring.starter.validation.ValidationUtils
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.stream.Collectors

@Service
class PersonServiceImpl(
    private val personRepository: PersonRepository,
    private val validationUtils: ValidationUtils
): PersonService {

    override fun create(createRequest: CreatePersonRequest): PersonResponse {
        validationUtils.validate(createRequest)
        val isExist = personRepository.findByIdOrNull(createRequest.idNumber)
        if (isExist != null) throw AlreadyExitsException()

        val person = Person(
            idNumber = createRequest.idNumber!!,
            fullName = createRequest.fullName!!,
            placeOfBirth = createRequest.placeOfBirth!!,
            dateOfBirth = LocalDate.parse(createRequest.dateOfBirth!!),
            gender = createRequest.gender!!,
            bloodGroup = createRequest.bloodGroup,
            address = createRequest.address,
            religion = createRequest.religion,
            maritalStatus = createRequest.maritalStatus,
            profession = createRequest.profession,
            citizenship = createRequest.citizenship,
            phoneNumber = createRequest.phoneNumber
        )

        personRepository.save(person)
        return convertPersonToResponse(person)
    }

    override fun get(idNumber: String): PersonResponse {
        val person = findPersonByIdOrThrowNotFound(idNumber)
        return convertPersonToResponse(person)
    }

    override fun update(idNumber: String, updateRequest: UpdatePersonRequest): PersonResponse {
        val person = findPersonByIdOrThrowNotFound(idNumber)
        validationUtils.validate(updateRequest)

        person.apply {
            fullName = updateRequest.fullName!!
            placeOfBirth = updateRequest.placeOfBirth!!
            dateOfBirth = LocalDate.parse(updateRequest.dateOfBirth!!)
            gender = updateRequest.gender!!
            bloodGroup = updateRequest.bloodGroup
            address = updateRequest.address
            religion = updateRequest.religion
            maritalStatus = updateRequest.maritalStatus
            profession = updateRequest.profession
            citizenship = updateRequest.citizenship
            phoneNumber = updateRequest.phoneNumber
        }
        personRepository.save(person)
        return convertPersonToResponse(person)
    }

    override fun delete(idNumber: String) {
        val person = findPersonByIdOrThrowNotFound(idNumber)
        personRepository.delete(person)
    }

    override fun list(listRequest: PaginationRequest): List<PersonResponse> {
        val page = personRepository.findAll(PageRequest.of(listRequest.page, listRequest.size))
        val persons: List<Person> = page.get().collect(Collectors.toList())
        return persons.map { convertPersonToResponse(it) }
    }

    private fun findPersonByIdOrThrowNotFound(idNumber: String): Person {
        val person = personRepository.findByIdOrNull(idNumber)
        if (person == null) {
            throw NotFoundException()
        } else {
            return person
        }
    }

    private fun convertPersonToResponse(person: Person): PersonResponse {
        return PersonResponse(
            idNumber = person.idNumber,
            fullName = person.fullName,
            placeOfBirth = person.placeOfBirth,
            dateOfBirth = person.dateOfBirth,
            gender = person.gender,
            bloodGroup = person.bloodGroup,
            address = person.address,
            religion = person.religion,
            maritalStatus = person.maritalStatus,
            profession = person.profession,
            citizenship = person.citizenship,
            phoneNumber = person.phoneNumber
        )
    }
}