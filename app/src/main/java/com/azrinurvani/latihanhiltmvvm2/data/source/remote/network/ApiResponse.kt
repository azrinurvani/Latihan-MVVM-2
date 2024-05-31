package com.azrinurvani.latihanhiltmvvm2.data.source.remote.network

sealed class ApiResponse<out T> private constructor(){

    data class Success<out T>(val data : T) : ApiResponse<T>()
    data class Error(val error : Throwable) : ApiResponse<Nothing>()

}