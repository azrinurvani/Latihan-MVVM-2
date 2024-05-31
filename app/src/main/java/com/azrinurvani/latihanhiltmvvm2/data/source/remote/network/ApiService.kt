package com.azrinurvani.latihanhiltmvvm2.data.source.remote.network

import com.azrinurvani.latihanhiltmvvm2.data.source.remote.response.PhotosResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/photos")
    suspend fun getAllPhotos() : List<PhotosResponse>

}