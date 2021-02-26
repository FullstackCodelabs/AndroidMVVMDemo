package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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
        binding = DataBindingUtil.setContentView(this, R.layout.posts_screen_activity)
        postsScreenViewModel = ViewModelProvider(this).get(PostsScreenViewModel::class.java)
        setupBinding()
        setObservers()
        postsScreenViewModel.fetchPosts()
    }

    private fun setupBinding() {
        binding.lifecycleOwner = this

        // Setup ViewModel
        binding.vm = postsScreenViewModel

        // Setup recyclerview
        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        binding.rvPosts.adapter = postsScreenAdapter
    }

    private fun setObservers() {
        postsScreenViewModel.status.observe(this, { status ->
            if (status == "loaded") {
                postsScreenAdapter.setPosts(postsScreenViewModel.posts as ArrayList<Post>)
            }
        })
    }

    fun retryButtonClicked(@Suppress("UNUSED_PARAMETER") view: View) {
        postsScreenViewModel.fetchPosts()
    }
}