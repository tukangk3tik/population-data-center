package com.spring.starter.model.person

import java.time.LocalDate

data class PersonResponse(
    val idNumber: String,
    val fullName: String,
    val placeOfBirth: String,
    val dateOfBirth: LocalDate,
    val gender: Short,
    val bloodGroup: String,
    val address: String,
    val religion: String,
    val maritalStatus: String,
    val profession: String,
    val citizenship: String,
    val phoneNumber: String
)
