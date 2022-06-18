package com.spring.starter.entity

import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted_at = ? WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
data class User(
    var email: String,

    @Column(unique = true)
    var password: String
): BaseEntity() {
    fun comparePassword(submitPassword: String): Boolean {
        return BCryptPasswordEncoder().matches(submitPassword, this.password);
    }
}
