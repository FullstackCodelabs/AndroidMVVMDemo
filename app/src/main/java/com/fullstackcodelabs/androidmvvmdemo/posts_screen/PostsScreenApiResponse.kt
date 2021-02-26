package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import com.fullstackcodelabs.androidmvvmdemo.models.Post

class PostsScreenApiResponse {
    var posts: List<Post>?
    var error: Throwable?

    constructor(posts: List<Post>?) {
        this.posts = posts
        error = null
    }

    constructor(error: Throwable?) {
        this.error = error
        posts = null
    }
}