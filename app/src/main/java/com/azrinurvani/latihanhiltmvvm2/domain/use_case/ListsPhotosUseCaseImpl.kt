package com.azrinurvani.latihanhiltmvvm2.domain.use_case

import com.azrinurvani.latihanhiltmvvm2.data.source.repository.PhotosRepository
import com.azrinurvani.latihanhiltmvvm2.data.source.Resource
import com.azrinurvani.latihanhiltmvvm2.domain.model.Photos
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListsPhotosUseCaseImpl @Inject constructor(
    private val repository: PhotosRepository
) : ListsPhotosUseCase {
    override fun getAllPosts(): Flow<Resource<List<Photos>>> {
        return repository.getAllPosts()
    }
}