package com.spring.starter.utils

import com.spring.starter.entity.Person
import com.spring.starter.model.person.CreatePersonRequest
import com.spring.starter.model.person.UpdatePersonRequest
import java.time.LocalDate
import java.time.LocalDateTime

val person = Person(
    "1207232810950003",
    "Damar Smitt",
    "Medan, Indonesia",
    LocalDate.parse("1995-03-27"),
    1,
    "AB",
    "Jl. Guru Sinumba No. 12",
    "Aliran Kepercayaan",
    "Belum Menikah",
    "Software developer",
    "WNI",
    "+6282235465728",
    0,
    LocalDateTime.parse("2022-06-01T10:00:00"),
    null,
    null
)

val personInsertSample = CreatePersonRequest(
    "1407232810950006",
    "Sukiman Petrus",
    "Medan, Indonesia",
    "1980-03-17",
    1,
    "O",
    "Jl. Asia",
    "Aliran Kepercayaan",
    "Duda",
    "Wakil Rektor",
    "WNI",
    "+6282235465728",
)

val personUpdateSample = UpdatePersonRequest(
    "Terda Smitt",
    "Medan, Indonesia",
    "1980-03-17",
    1,
    "O",
    "Jl. Asia",
    "Aliran Kepercayaan",
    "Duda",
    "Wakil Rektor",
    "WNI",
    "+6282235465728",
)