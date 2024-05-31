package com.azrinurvani.latihanhiltmvvm2.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azrinurvani.latihanhiltmvvm2.R
import com.azrinurvani.latihanhiltmvvm2.databinding.ItemPhotosBinding
import com.azrinurvani.latihanhiltmvvm2.domain.model.Photos
import com.azrinurvani.latihanhiltmvvm2.util.Utils.loadImageBitmap

class PhotosRecyclerAdapter(val list: List<Photos>) : RecyclerView.Adapter<PhotosRecyclerAdapter.PhotosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val view = ItemPhotosBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PhotosViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    inner class PhotosViewHolder(private val binding : ItemPhotosBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(data : Photos?){
            binding.apply {
                loadImageBitmap(
                    context = itemView.context,
                    placeHolder = R.drawable.news_placeholder,
                    imageView = imgPhotos,
                    uri = data?.url.toString()
                )
                tvTitle.text = data?.title
                tvThumbnailUrl.text = data?.thumbnailUrl
            }
        }
    }
}