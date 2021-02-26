package com.fullstackcodelabs.androidmvvmdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fullstackcodelabs.androidmvvmdemo.posts_screen.PostsScreenActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun viewPostsButtonClicked(view: View) {
        val intent = Intent(this, PostsScreenActivity::class.java).apply {}
        startActivity(intent)
    }
}