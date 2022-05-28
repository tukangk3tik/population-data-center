package com.spring.starter.model.person

import java.time.LocalDate
import java.util.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdatePersonRequest(
    @field:NotBlank
    val fullName: String?,

    @field:NotBlank
    val placeOfBirth: String?,

    @field:NotBlank
    val dateOfBirth: LocalDate?,

    @field:NotNull
    @field:Min(value = 0)
    @field:Max(value = 1)
    val gender: Short?,

    @field:NotBlank
    val bloodGroup: String,

    @field:NotBlank
    val address: String,

    @field:NotBlank
    val religion: String,

    @field:NotBlank
    val maritalStatus: String,

    @field:NotBlank
    val profession: String,

    @field:NotBlank
    val citizenship: String,

    @field:NotBlank
    val phoneNumber: String
)
