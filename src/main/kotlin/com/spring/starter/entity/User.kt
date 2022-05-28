package com.spring.starter.entity

import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import javax.persistence.*

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted_at = ? WHERE id = ?")
@Where(clause = "deleted_at = NULL")
data class User(
    var email: String,
    var password: String
): BaseEntity()
