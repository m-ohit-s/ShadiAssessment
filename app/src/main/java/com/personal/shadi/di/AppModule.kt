package com.personal.shadi.di

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.personal.shadi.common.Constants.BASE_URL
import com.personal.shadi.common.Constants.DATABASE
import com.personal.shadi.common.Constants.PAGE_SIZE
import com.personal.shadi.data.local.UserEntity
import com.personal.shadi.data.local.db.UserDatabase
import com.personal.shadi.data.remote.UserRemoteMediator
import com.personal.shadi.data.remote.api.UserApi
import com.personal.shadi.domain.repository.UserRepository
import com.personal.shadi.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserApi(): UserApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi, db: UserDatabase): UserRepository {
        return UserRepositoryImpl(api, db)
    }
}