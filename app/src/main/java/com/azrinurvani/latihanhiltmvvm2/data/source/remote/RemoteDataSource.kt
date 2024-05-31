package com.azrinurvani.latihanhiltmvvm2.data.source.remote

import android.util.Log
import com.azrinurvani.latihanhiltmvvm2.data.source.remote.network.ApiResponse
import com.azrinurvani.latihanhiltmvvm2.data.source.remote.network.ApiService
import com.azrinurvani.latihanhiltmvvm2.data.source.remote.response.PhotosResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllPosts() : Flow<ApiResponse<List<PhotosResponse>>> = flow {
        try {
            emit(
                ApiResponse.Success(apiService.getAllPhotos())
            )
        }catch (t : Throwable){
            emit(ApiResponse.Error(t))
            Log.e(javaClass.name, "getAllPosts: $t")
        }
    }
}