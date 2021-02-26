package com.fullstackcodelabs.androidmvvmdemo.posts_screen

import com.fullstackcodelabs.androidmvvmdemo.models.Post

class PostsScreenApiResponse {
    var status: String = "loading"
    var posts: List<Post>?
    var error: Throwable?

    constructor() {
        this.status = "loading"
        this.posts = null
        error = null
    }

    constructor(posts: List<Post>?) {
        this.status = "loaded"
        this.posts = posts
        error = null
    }

    constructor(error: Throwable?) {
        this.status = "failed"
        this.error = error
        posts = null
    }
}