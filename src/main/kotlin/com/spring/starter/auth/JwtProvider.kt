package com.spring.starter.auth

import com.spring.starter.error.TokenInvalidException
import com.spring.starter.utils.secretJwt
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*

object JwtProvider {

    fun generateToken(userId: Int): Map<String, Any> {
        val expiresIn = System.currentTimeMillis() + 60 * 24 * 1000 // 1 day
        val token = Jwts.builder()
            .setIssuer(userId.toString())
            .setExpiration(Date(expiresIn))
            .signWith(SignatureAlgorithm.HS512, secretJwt)
            .compact()

        return mapOf("expiresIn" to expiresIn, "token" to token)
    }

    fun validateToken(token: String){
        try {
            Jwts.parser().setSigningKey(secretJwt).parseClaimsJws(token).body
        } catch (e: Exception) {
            println(e)
            throw TokenInvalidException()
        }
    }
}