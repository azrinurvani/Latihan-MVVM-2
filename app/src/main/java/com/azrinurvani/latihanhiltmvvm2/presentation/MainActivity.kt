package com.azrinurvani.latihanhiltmvvm2.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.azrinurvani.latihanhiltmvvm2.data.source.Resource
import com.azrinurvani.latihanhiltmvvm2.databinding.ActivityMainBinding
import com.azrinurvani.latihanhiltmvvm2.presentation.adapter.PhotosRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observerListPosts()
    }

    private fun observerListPosts(){
        viewModel.getAllPostsLiveData.observe(this){ result->
            when(result){
                is Resource.Loading ->  {
                    showLoading(true)
                }
                is  Resource.Error -> {
                    showError(result.message.toString())
                }
                is Resource.Success->{
                    showLoading(false)
                    if (!result.data.isNullOrEmpty()){
                        val photosRecyclerAdapter = PhotosRecyclerAdapter(result.data)
                        binding.rvPhotos.apply {
                            adapter = photosRecyclerAdapter
                            layoutManager = LinearLayoutManager(this@MainActivity)
                        }
                    }else{
                        showEmptyData()
                    }
                }
            }
        }
    }

    private fun showLoading(isLoading : Boolean){
        binding.apply {
            scrollShimmer.isVisible = isLoading
            shimmerLoading.apply {
                if (isLoading){
                    startShimmer()
                }else{
                    stopShimmer()
                }
            }
            tvState.visibility = View.GONE
        }
    }

    private fun showError(error : String){
        showLoading(false)
        binding.rvPhotos.visibility = View.GONE
        binding.tvState.apply {
            visibility = View.GONE
            text = error
        }
    }

    private fun showEmptyData(){
        binding.rvPhotos.visibility = View.GONE
        binding.tvState.apply {
            visibility = View.GONE
            text = error
        }
    }
}