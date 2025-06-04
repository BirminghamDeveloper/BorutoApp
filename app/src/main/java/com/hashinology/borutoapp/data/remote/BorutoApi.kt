package com.hashinology.borutoapp.data.remote

import com.hashinology.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoApi {
    @GET("/boruto/heroes")
    suspend fun getAllHerpes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse
}