package com.example.videostreamingassignment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btn1Click(view: View) {
        val i = Intent(this, viedo1::class.java)

        startActivity(i)
    }
    fun btn2Click(view: View) {
        val i = Intent(this, viedo2::class.java)

        startActivity(i)
    }
    fun btn3Click(view: View) {
        val i = Intent(this, video3::class.java)

        startActivity(i)
    }
    fun btn4Click(view: View) {
        val i = Intent(this, v4::class.java)

        startActivity(i)
    }





}

