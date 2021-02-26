package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData


class PostsScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val mApiResponse: MediatorLiveData<PostsScreenApiResponse> =
        MediatorLiveData<PostsScreenApiResponse>()
    private val postsScreenRepository = PostsScreenRepository()
    val status: ObservableField<String> = ObservableField<String>("loading")

//    val posts: LiveData<List<Post>>
//        get() = postsScreenRepository.getMutableLiveData()

    fun loadPosts(): LiveData<PostsScreenApiResponse?> {
        mApiResponse.addSource(postsScreenRepository.getMutableLiveData()) { apiResponse ->
            mApiResponse.setValue(apiResponse)
        }
        return mApiResponse
    }

}