package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fullstackcodelabs.androidmvvmdemo.R
import com.fullstackcodelabs.androidmvvmdemo.databinding.PostsScreenPostItemBinding
import com.fullstackcodelabs.androidmvvmdemo.models.Post


class PostsScreenAdapter : RecyclerView.Adapter<PostsScreenAdapter.PostViewHolder>() {
    private var posts: ArrayList<Post>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PostViewHolder {
        val postsScreenPostItemBinding: PostsScreenPostItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.posts_screen_post_item, viewGroup, false
        )
        return PostViewHolder(postsScreenPostItemBinding)
    }

    override fun onBindViewHolder(postViewHolder: PostViewHolder, i: Int) {
        val currentPost: Post = posts!![i]
        postViewHolder.postsScreenPostItemBinding.post = currentPost
    }

    override fun getItemCount(): Int {
        return if (posts != null) {
            posts!!.size
        } else {
            0
        }
    }

    fun setPosts(posts: ArrayList<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    inner class PostViewHolder(var postsScreenPostItemBinding: PostsScreenPostItemBinding) :
        RecyclerView.ViewHolder(postsScreenPostItemBinding.root)
}