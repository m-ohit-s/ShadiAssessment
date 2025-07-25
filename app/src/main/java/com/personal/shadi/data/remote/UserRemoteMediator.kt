package com.personal.shadi.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.personal.shadi.data.local.UserEntity
import com.personal.shadi.data.local.db.UserDatabase
import com.personal.shadi.data.remote.api.UserApi
import com.personal.shadi.data.remote.dto.toEntity
import okio.IOException
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class UserRemoteMediator(
    private val userDb: UserDatabase,
    private val userApi: UserApi
) : RemoteMediator<Int, UserEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UserEntity>
    ): MediatorResult {
        return try {
            val page = when(loadType) {
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) 1 else (state.pages.size + 1)
                }
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            }

            val response = userApi.getUsersList(page = page, results = state.config.pageSize)
            val userEntities = response.results.map { it.toEntity() }
            userDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    userDb.dao.clearAll()
                }
                userDb.dao.upsertAll(userEntities)
            }

            MediatorResult.Success(endOfPaginationReached = userEntities.isEmpty())
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        }
    }
}