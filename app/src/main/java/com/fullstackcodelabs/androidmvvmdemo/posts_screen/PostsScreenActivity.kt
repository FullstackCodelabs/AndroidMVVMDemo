package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.os.Bundle
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

        // Setup binding and ViewModel
        binding = DataBindingUtil.setContentView(this, R.layout.posts_screen_activity)
        postsScreenViewModel = ViewModelProvider(this).get(PostsScreenViewModel::class.java)

        // Setup recyclerview
        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        binding.rvPosts.adapter = postsScreenAdapter

        setObservers()
    }

    private fun setObservers() {
        postsScreenViewModel.posts.observe(this, { posts ->
            postsScreenAdapter.setPosts(posts as ArrayList<Post>)
            postsScreenAdapter.notifyDataSetChanged()
        })
    }
}