package com.hashinology.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val Success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero> = emptyList()
)
