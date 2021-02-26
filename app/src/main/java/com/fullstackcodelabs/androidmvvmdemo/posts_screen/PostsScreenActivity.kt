package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fullstackcodelabs.androidmvvmdemo.R
import com.fullstackcodelabs.androidmvvmdemo.databinding.PostsScreenActivityBinding
import com.fullstackcodelabs.androidmvvmdemo.models.Post


class PostsScreenActivity : AppCompatActivity() {
    private lateinit var binding: PostsScreenActivityBinding
    private lateinit var postsScreenViewModel: PostsScreenViewModel
    private var postsScreenAdapter: PostsScreenAdapter = PostsScreenAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup binding and ViewModel
        binding = DataBindingUtil.setContentView(this, R.layout.posts_screen_activity)
        postsScreenViewModel = ViewModelProvider(this).get(PostsScreenViewModel::class.java)

        // Set data variable for viewmodel
        binding.vm = postsScreenViewModel

        // Setup recyclerview
        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        binding.rvPosts.adapter = postsScreenAdapter

        setObservers()
    }

    private fun setObservers() {
        postsScreenViewModel.loadPosts().observe(this, object : Observer<PostsScreenApiResponse?> {
            override fun onChanged(postsScreenApiResponse: PostsScreenApiResponse?) {
                if (postsScreenApiResponse == null) {
                    // handle error here
                    return
                }
                if (postsScreenApiResponse.error == null) {
                    postsScreenViewModel.status.set("loaded")
                    postsScreenAdapter.setPosts(postsScreenApiResponse.posts as ArrayList<Post>)
                } else {
                    // call failed.
                    val e: Throwable = postsScreenApiResponse.error!!
                    Toast.makeText(
                        this@PostsScreenActivity,
                        "Error is " + e.message,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    Log.e("TAG", "Error is " + e.localizedMessage)
                }
            }
        })
    }

    fun retryButtonClicked(view: View) {
        postsScreenViewModel.loadPosts()
    }
}