package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.util.Log
import com.fullstackcodelabs.androidmvvmdemo.models.Post
import com.fullstackcodelabs.androidmvvmdemo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsScreenRepository {
    val apiResponse = PostsScreenApiResponse()

    fun fetchPosts() {
        apiResponse.status.postValue("loading")

        val call = RetrofitClient.getService().posts()
        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful && response.body() != null) {
                    apiResponse.loadingSucceeded(response.body() as ArrayList<Post>)
                    return
                }

                apiResponse.loadingFailed()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d(TAG, "Failed to load posts ${t.message}")
                apiResponse.loadingFailed()
            }
        })
    }

    companion object {
        private const val TAG = "PostsScreenRepository"
    }
}