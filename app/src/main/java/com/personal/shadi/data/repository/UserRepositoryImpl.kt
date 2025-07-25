package com.personal.shadi.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.personal.shadi.common.ProfileStatus
import com.personal.shadi.data.local.db.UserDatabase
import com.personal.shadi.data.local.toUser
import com.personal.shadi.data.remote.UserRemoteMediator
import com.personal.shadi.data.remote.api.UserApi
import com.personal.shadi.domain.model.User
import com.personal.shadi.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
    private val db: UserDatabase
) : UserRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun fetchUserList(
        results: Int,
        page: Int
    ): Flow<PagingData<User>> {
        val pagingSourceFactory = { db.dao.getAllUsers() }
        return Pager(
            config = PagingConfig(pageSize = results),
            remoteMediator = UserRemoteMediator(
                userDb = db,
                userApi = api
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow.map { pagingData ->
            pagingData.map { it.toUser() }
        }
    }

    override suspend fun updateUserStatus(userId: String, status: ProfileStatus) {
        db.dao.updateUserStatus(userId, status.name)
    }
}