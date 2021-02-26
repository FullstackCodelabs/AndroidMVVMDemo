package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fullstackcodelabs.androidmvvmdemo.R
import com.fullstackcodelabs.androidmvvmdemo.databinding.PostsScreenPostItemBinding
import com.fullstackcodelabs.androidmvvmdemo.models.Post


class PostsScreenAdapter : RecyclerView.Adapter<PostsScreenAdapter.PostViewHolder>() {
    private var posts = mutableListOf<Post>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PostViewHolder {
        val postsScreenPostItemBinding: PostsScreenPostItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.posts_screen_post_item, viewGroup, false
        )
        return PostViewHolder(postsScreenPostItemBinding)
    }

    override fun onBindViewHolder(postViewHolder: PostViewHolder, i: Int) {
        postViewHolder.postsScreenPostItemBinding.post = posts[i]
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setPosts(posts: ArrayList<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    inner class PostViewHolder(var postsScreenPostItemBinding: PostsScreenPostItemBinding) :
        RecyclerView.ViewHolder(postsScreenPostItemBinding.root)
}