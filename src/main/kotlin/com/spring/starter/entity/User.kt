package com.spring.starter.entity

import org.hibernate.annotations.SQLDelete
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted_at = ? WHERE id = ?")
data class User(
    var email: String,
    var password: String
): BaseEntity()
