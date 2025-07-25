package com.personal.shadi.domain.use_case

import androidx.paging.PagingData
import com.personal.shadi.common.Resource
import com.personal.shadi.data.remote.dto.toUser
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
    operator fun invoke(results: Int, page: Int): Flow<PagingData<User>>  = repository.fetchUserList(results, page)
}