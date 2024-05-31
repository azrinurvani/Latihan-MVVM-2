package com.azrinurvani.latihanhiltmvvm2.di

import android.util.Log
import com.azrinurvani.latihanhiltmvvm2.data.source.remote.network.ApiService
import com.azrinurvani.latihanhiltmvvm2.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesLoggingInterceptor() : HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor{ message->
            Log.d("API-LOG", message)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return interceptor
    }


    @Provides
    @Singleton
    fun providesHttpClient(logging : HttpLoggingInterceptor) : OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(
                Constants.CONNECT_TIMEOUT,TimeUnit.SECONDS
            )
            .readTimeout(
                Constants.READ_TIMEOUT,TimeUnit.SECONDS
            )
            .callTimeout(
                Constants.CALL_TIMEOUT,TimeUnit.SECONDS
            )
            .addNetworkInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofitBuilder(client : OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }
}