package com.spring.starter.repository

import com.spring.starter.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, String>