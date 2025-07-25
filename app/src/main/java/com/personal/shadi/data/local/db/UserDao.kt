package com.personal.shadi.data.local.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.personal.shadi.data.local.UserEntity

@Dao
interface UserDao {
    @Upsert
    suspend fun upsertAll(users: List<UserEntity>)

    @Query("DELETE FROM user")
    suspend fun clearAll()

    @Query("SELECT * FROM user")
    fun getAllUsers(): PagingSource<Int, UserEntity>

    @Query("UPDATE user SET status = :status WHERE id = :userId")
    suspend fun updateUserStatus(userId: String, status: String)
}