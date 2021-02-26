package com.fullstackcodelabs.androidmvvmdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    companion object {
        private var retrofit: Retrofit? = null
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun getService(): RetrofitService {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(RetrofitService::class.java)
        }
    }
}