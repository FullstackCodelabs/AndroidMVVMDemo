package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.fullstackcodelabs.androidmvvmdemo.models.Post


class PostsScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val postsScreenRepository = PostsScreenRepository()
    private var postsScreenApiResponse = postsScreenRepository.apiResponse

    val status: MutableLiveData<String>
        get() = postsScreenApiResponse.status

    val posts: List<Post>
        get() = postsScreenApiResponse.posts

    val errorMessage: MutableLiveData<String>
        get() = postsScreenApiResponse.errorMessage

    fun fetchPosts() {
        postsScreenRepository.fetchPosts()
    }
}