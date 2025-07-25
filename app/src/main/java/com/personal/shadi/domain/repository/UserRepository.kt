package com.personal.shadi.domain.repository

import com.personal.shadi.data.remote.api.dto.ResultsDto

interface UserRepository {
    suspend fun getUsersList(results: Int, page: Int): ResultsDto
}