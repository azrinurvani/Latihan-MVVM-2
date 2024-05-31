package com.azrinurvani.latihanhiltmvvm2.data.source

sealed class Resource<out T>(val data: T?, val message : String? = null) {

    class Loading<T>(data:T? = null) : Resource<T>(data)
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(data: T? = null,message: String? ): Resource<T>(data,message)

}