package com.spring.starter.model.general

/**
 * Standard format for API response
 */

data class WebResponse<T>(
    val status: String = "success",
    val message: String,
    val data: T
)