package com.spring.starter.entity

import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "persons")
@SQLDelete(sql = "UPDATE persons SET deleted_at = ? WHERE id_number = ?")
@Where(clause = "deleted_at IS NULL")
data class Person(
    @Id
    @Column(name = "id_number")
    var idNumber: String,

    @Column(name = "full_name")
    var fullName: String,

    @Column(name = "place_of_birth")
    var placeOfBirth: String,

    @Column(name = "date_of_birth")
    var dateOfBirth: LocalDate,

    @Column(name = "gender")
    var gender: Short,

    @Column(name = "blood_group")
    var bloodGroup: String,

    @Column(name = "address")
    var address: String,

    @Column(name = "religion")
    var religion: String,

    @Column(name = "marital_status")
    var maritalStatus: String,

    @Column(name = "profession")
    var profession: String,

    @Column(name = "citizenship")
    var citizenship: String,

    @Column(name = "phone_number")
    var phoneNumber: String,

    @Version
    var version: Long? = null,

    @CreatedDate
    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null,

    @LastModifiedDate
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null,

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null
)
