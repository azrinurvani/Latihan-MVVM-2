package com.azrinurvani.latihanhiltmvvm2.util

import android.content.Context
import android.widget.ImageView
import com.azrinurvani.latihanhiltmvvm2.data.source.remote.response.PhotosResponse
import com.azrinurvani.latihanhiltmvvm2.domain.model.Photos
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object Utils {

    fun mapperResponseToDomain(response: List<PhotosResponse>) : List<Photos>{
        val mutablePosts : MutableList<Photos> = mutableListOf()
        response.forEach{
            Photos(
                albumId = it.albumId,
                id = it.id,
                title = it.title,
                thumbnailUrl = it.thumbnailUrl,
                url = it.url,
            ).let(mutablePosts::add)
        }
        return mutablePosts
    }

    fun loadImageBitmap(context: Context, placeHolder: Int, uri:String, imageView : ImageView){
        Glide.with(context)
            .asBitmap()
            .placeholder(placeHolder)
            .apply(RequestOptions().centerCrop())
            .load(uri)
            .into(imageView)
    }

}