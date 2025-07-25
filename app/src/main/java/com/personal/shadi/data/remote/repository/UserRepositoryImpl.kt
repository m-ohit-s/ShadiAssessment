package com.personal.shadi.data.remote.repository

import com.personal.shadi.data.remote.api.UserApi
import com.personal.shadi.data.remote.api.dto.ResultsDto
import com.personal.shadi.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
) : UserRepository {
    override suspend fun getUsersList(
        results: Int,
        page: Int
    ): ResultsDto {
        return api.getUsersList(results, page)
    }
}