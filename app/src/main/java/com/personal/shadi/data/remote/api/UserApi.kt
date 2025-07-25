package com.personal.shadi.data.remote.api

import com.personal.shadi.data.remote.api.dto.ResultsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("api/")
    suspend fun getUsersList(
        @Query("results") results: Int,
        @Query("page") page: Int
    ): ResultsDto
}