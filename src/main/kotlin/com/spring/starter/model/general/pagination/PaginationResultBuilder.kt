package com.spring.starter.model.general.pagination

data class PaginationResultBuilder<T>(
    var _metadata: PaginationMetadata,
    var records : List<T>
)

