package com.azrinurvani.latihanhiltmvvm2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.azrinurvani.latihanhiltmvvm2.domain.use_case.ListsPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val listsPhotosUseCase: ListsPhotosUseCase
) : ViewModel() {

    val getAllPostsLiveData = listsPhotosUseCase.getAllPosts().asLiveData()

}