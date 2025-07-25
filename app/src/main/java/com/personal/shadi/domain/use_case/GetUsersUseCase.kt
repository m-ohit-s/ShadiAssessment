package com.personal.shadi.domain.use_case

import com.personal.shadi.common.Resource
import com.personal.shadi.data.remote.api.dto.ResultsDto
import com.personal.shadi.data.remote.api.dto.toUser
import com.personal.shadi.domain.repository.UserRepository
import com.personal.shadi.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(results: Int, page: Int): Flow<Resource<List<User>>> = flow {
        try {
            emit(Resource.Loading())
            val users = repository.getUsersList(results, page)
            emit(Resource.Success(users.results.map { it.toUser() }))
        } catch (httpException: HttpException) {
            emit(Resource.Error(httpException.localizedMessage ?: "An unexpected error occurred"))
        } catch (ioException: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}