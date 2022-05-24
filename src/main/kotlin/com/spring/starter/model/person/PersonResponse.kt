package com.spring.starter.model.person

import java.util.*

data class PersonResponse(
    val idNumber: String,
    val fullName: String,
    val placeOfBirth: String,
    val dateOfBirth: Date,
    val gender: Int,
    val bloodGroup: String,
    val address: String,
    val religion: String,
    val maritalStatus: String,
    val profession: String,
    val citizenship: String,
    val phoneNumber: String
)
