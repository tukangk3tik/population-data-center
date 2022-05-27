package com.spring.starter.entity

import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "persons")
@SQLDelete(sql = "UPDATE persons SET deleted_at = ? WHERE id = ?")
@Where(clause = "deleted_at")
data class Person(
    @Column(name = "id_number")
    var idNumber: String,

    @Column(name = "full_name")
    var fullName: String,

    @Column(name = "place_of_birth")
    var placeOfBirth: String,

    @Column(name = "date_of_birth")
    var dateOfBirth: Date,

    @Column(name = "gender")
    var gender: Int,

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
    var phoneNumber: String
): BaseEntity()
