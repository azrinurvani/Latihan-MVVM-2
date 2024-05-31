package com.azrinurvani.latihanhiltmvvm2.di

import com.azrinurvani.latihanhiltmvvm2.data.source.repository.PhotosRepository
import com.azrinurvani.latihanhiltmvvm2.data.source.repository.PhotosRepositoryImpl
import com.azrinurvani.latihanhiltmvvm2.data.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePostsRepository(remoteDataSource: RemoteDataSource) : PhotosRepository {
        return PhotosRepositoryImpl(remoteDataSource)
    }
}