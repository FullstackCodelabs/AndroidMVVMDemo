package com.fullstackcodelabs.androidmvvmdemo.network

import com.fullstackcodelabs.androidmvvmdemo.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("posts")
    fun posts(): Call<List<Post>>
}