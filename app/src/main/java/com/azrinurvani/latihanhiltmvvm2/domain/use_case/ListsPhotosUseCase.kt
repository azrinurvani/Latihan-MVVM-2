package com.azrinurvani.latihanhiltmvvm2.domain.use_case

import com.azrinurvani.latihanhiltmvvm2.data.source.Resource
import com.azrinurvani.latihanhiltmvvm2.domain.model.Photos
import kotlinx.coroutines.flow.Flow

interface ListsPhotosUseCase {

    fun getAllPosts() : Flow<Resource<List<Photos>>>
}