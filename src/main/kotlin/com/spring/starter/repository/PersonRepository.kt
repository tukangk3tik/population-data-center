package com.spring.starter.repository

import com.spring.starter.entity.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface PersonRepository : JpaRepository<Person, String> {

    @Modifying
    @Query("UPDATE Person SET deleted_at = NOW() WHERE id_number = :id")
    override fun deleteById(id: String)
}