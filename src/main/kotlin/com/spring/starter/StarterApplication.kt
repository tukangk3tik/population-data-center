package com.spring.starter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class StarterApplication

fun main(args: Array<String>) {
	runApplication<StarterApplication>(*args)
}