package com.azrinurvani.latihanhiltmvvm2.di

import com.azrinurvani.latihanhiltmvvm2.domain.use_case.ListsPhotosUseCase
import com.azrinurvani.latihanhiltmvvm2.domain.use_case.ListsPhotosUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindUseCaseModule(listsPostsUseCase: ListsPhotosUseCaseImpl) : ListsPhotosUseCase
}