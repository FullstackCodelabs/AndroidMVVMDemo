package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fullstackcodelabs.androidmvvmdemo.models.Post
import com.fullstackcodelabs.androidmvvmdemo.network.RetrofitClient
import retrofit2.Callback
import retrofit2.Response

class PostsScreenRepository {
    private val mutableLiveData = MutableLiveData<List<Post>>()

    fun getMutableLiveData(): MutableLiveData<List<Post>> {
        val call = RetrofitClient.getService().posts()

        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(
                call: retrofit2.Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                response.body()?.let {
                    mutableLiveData.value = it
                }
            }

            override fun onFailure(call: retrofit2.Call<List<Post>>, t: Throwable) {
                Log.d(TAG, "Failed to load posts ${t.message}")
            }
        })

        return mutableLiveData
    }

    companion object {
        private const val TAG = "PostsScreenRepository"
    }
}