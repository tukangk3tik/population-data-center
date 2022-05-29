package com.spring.starter.model.general.pagination

data class PaginationMetadata(
    var page: Int,
    var perPage: Int,
    var total: Int,
)
