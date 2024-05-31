package com.azrinurvani.latihanhiltmvvm2.data.source.repository

import com.azrinurvani.latihanhiltmvvm2.data.source.Resource
import com.azrinurvani.latihanhiltmvvm2.domain.model.Photos
import kotlinx.coroutines.flow.Flow


interface PhotosRepository {

    fun getAllPosts() : Flow<Resource<List<Photos>>>

}