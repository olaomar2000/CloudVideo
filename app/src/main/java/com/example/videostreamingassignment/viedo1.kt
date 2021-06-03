package com.example.videostreamingassignment

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class viedo1 : AppCompatActivity() {
    lateinit var playerView: PlayerView
    var player: SimpleExoPlayer? = null

    var playWhenReady = true
    var currentWindow = 0
    var playBackPosition: Long = 0
    var url = "https://firebasestorage.googleapis.com/v0/b/push-notifications-32c15.appspot.com/o/video%2FNature%20Beautiful%20short%20video%20720p%20HD.mp4?alt=media&token=63c211c1-61cb-4dea-b44f-f5844590da71"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viedo1)

        playerView = findViewById(R.id.video_view1)
    }

    fun initVideo() {
        player = ExoPlayerFactory.newSimpleInstance(this)
        playerView.player = player
        var uri = Uri.parse(url)

        var dataSourceFactory = DefaultDataSourceFactory(this, "exoplayer-codelab")
        var mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)

        player!!.playWhenReady = playWhenReady
        player!!.seekTo(currentWindow, playBackPosition)
        player!!.prepare(mediaSource, false, false)

    }

    fun releaseVideo() {
        if (player != null) {
            playWhenReady = player!!.playWhenReady
            playBackPosition = player!!.currentPosition
            currentWindow = player!!.currentWindowIndex
            player!!.release()
            player = null
        }
    }

    override fun onStart() {
        super.onStart()
        initVideo()
    }


    override fun onStop() {
        super.onStop()
        releaseVideo()
    }

    override fun onPause() {
        super.onPause()
        releaseVideo()
    }
}