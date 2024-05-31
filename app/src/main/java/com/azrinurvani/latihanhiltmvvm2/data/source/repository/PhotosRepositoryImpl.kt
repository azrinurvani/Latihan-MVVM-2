package com.azrinurvani.latihanhiltmvvm2.data.source.repository

import android.util.Log
import com.azrinurvani.latihanhiltmvvm2.data.source.Resource
import com.azrinurvani.latihanhiltmvvm2.data.source.remote.RemoteDataSource
import com.azrinurvani.latihanhiltmvvm2.data.source.remote.network.ApiResponse
import com.azrinurvani.latihanhiltmvvm2.domain.model.Photos
import com.azrinurvani.latihanhiltmvvm2.util.Utils.mapperResponseToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotosRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    PhotosRepository {
    override fun getAllPosts(): Flow<Resource<List<Photos>>> = flow {
        emit(Resource.Loading())
        try {
            when(val response = remoteDataSource.getAllPosts().single()){
                is ApiResponse.Error ->{
                    emit(Resource.Error(message = response.error.toString()))
                }
                is ApiResponse.Success ->{
                    Log.d(javaClass.name, "response data : ${response.data}")
                    emit(Resource.Success(mapperResponseToDomain(response.data)))
                }
            }

        }catch (t : Throwable){
            emit(Resource.Error(message = t.message.toString()))
        }
    }

}