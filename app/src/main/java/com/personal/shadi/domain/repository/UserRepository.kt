package com.personal.shadi.domain.repository

import androidx.paging.PagingData
import com.personal.shadi.common.ProfileStatus
import com.personal.shadi.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun fetchUserList(results: Int, page: Int): Flow<PagingData<User>>
    suspend fun updateUserStatus(userId: String, status: ProfileStatus)
}