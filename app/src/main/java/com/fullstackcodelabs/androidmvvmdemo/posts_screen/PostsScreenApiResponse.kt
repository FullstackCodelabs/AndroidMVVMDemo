package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import androidx.lifecycle.MutableLiveData
import com.fullstackcodelabs.androidmvvmdemo.models.Post

class PostsScreenApiResponse {
    var status = MutableLiveData("loading")
    var posts = mutableListOf<Post>()
    var errorMessage: MutableLiveData<String> = MutableLiveData(null)

    fun loadingSucceeded(posts: ArrayList<Post>) {
        this.status.postValue("loaded")
        this.posts = posts
    }

    fun loadingFailed() {
        this.status.postValue("failed")
        this.errorMessage.postValue("Failed to load posts. Please try again.")
    }
}