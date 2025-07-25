package com.personal.shadi.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.personal.shadi.data.local.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class UserDatabase: RoomDatabase() {
    abstract val dao: UserDao
}