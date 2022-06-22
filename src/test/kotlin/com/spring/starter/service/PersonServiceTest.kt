package com.spring.starter.service

import com.spring.starter.entity.Person
import com.spring.starter.error.NotFoundException
import com.spring.starter.model.person.CreatePersonRequest
import com.spring.starter.repository.PersonRepository
import com.spring.starter.service.impl.PersonServiceImpl
import com.spring.starter.utils.person
import com.spring.starter.utils.personInsertSample
import com.spring.starter.utils.personUpdateSample
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Extensions(value = [ExtendWith(MockitoExtension::class)])
class PersonServiceTest {
    @Mock
    lateinit var personRepository: PersonRepository
    private lateinit var personService: PersonService

    @BeforeEach
    fun beforeEach() {
        personService = PersonServiceImpl(personRepository)
    }

    @Test
    fun `get person invalid id`() {
        assertThrows<NotFoundException>{
            personService.get("    ")
        }
    }

    @Test
    fun `get person not found`() {
        assertThrows<NotFoundException>{
            personService.get("11111")
        }
    }

    @Test
    fun `get 1 person by id then return person response`() {
        val idNumber = "1207232810950003"
        Mockito.`when`(personRepository.findById(idNumber)).thenReturn(Optional.of(person))

        val comparePerson = personService.convertPersonToResponse(person)
        val result = personService.get(idNumber)
        assertEquals(result, comparePerson)
    }

    @Test
    fun `insert person success`(){
        val result = personService.create(personInsertSample)
        assertEquals(result.idNumber, personInsertSample.idNumber)
        assertEquals(result.fullName, personInsertSample.fullName)
    }

    @Test
    fun `update person success`(){
        val idNumber = "1207232810950003"
        Mockito.`when`(personRepository.findById(idNumber)).thenReturn(Optional.of(person))

        val result = personService.update(idNumber, personUpdateSample)
        assertEquals(result.idNumber, idNumber)
        assertEquals(result.fullName, personUpdateSample.fullName)
    }

    @Test
    fun `delete person success`(){
        val idNumber = "1207232810950003"
        Mockito.`when`(personRepository.findById(idNumber)).thenReturn(Optional.of(person))

        personService.delete(idNumber)
    }
}