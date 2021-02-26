package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel


class PostsScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val postsScreenRepository = PostsScreenRepository()
    var postsScreenApiResponse = postsScreenRepository.apiResponse

    fun loadPosts() {
        postsScreenRepository.getMutableLiveData()
    }
}