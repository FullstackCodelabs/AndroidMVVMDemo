package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.fullstackcodelabs.androidmvvmdemo.models.Post

class PostsScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val postsScreenRepository = PostsScreenRepository()

    val posts: LiveData<List<Post>>
        get() = postsScreenRepository.getMutableLiveData()
}