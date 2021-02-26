package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fullstackcodelabs.androidmvvmdemo.models.Post
import com.fullstackcodelabs.androidmvvmdemo.network.RetrofitClient
import retrofit2.Callback
import retrofit2.Response

class PostsScreenRepository {
    val apiResponse = MutableLiveData<PostsScreenApiResponse>()

    fun getMutableLiveData(): MutableLiveData<PostsScreenApiResponse> {
        val call = RetrofitClient.getService().posts()

        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(
                call: retrofit2.Call<List<Post>>,
                response: Response<List<Post>>
            ) {
                if (response.isSuccessful) {
                    apiResponse.postValue(PostsScreenApiResponse(response.body()))
                } else {
                    apiResponse.postValue(PostsScreenApiResponse(Error("Failed to load posts.")))
                }
            }

            override fun onFailure(call: retrofit2.Call<List<Post>>, t: Throwable) {
                Log.d(TAG, "Failed to load posts ${t.message}")
                apiResponse.postValue(PostsScreenApiResponse(t))
            }
        })

        return apiResponse
    }

    companion object {
        private const val TAG = "PostsScreenRepository"
    }
}