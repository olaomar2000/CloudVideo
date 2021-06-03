package com.example.videostreamingassignment

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class viedo2 : AppCompatActivity() {
    lateinit var playerView: PlayerView
    var player: SimpleExoPlayer? = null

    var playWhenReady = true
    var currentWindow = 0
    var playBackPosition: Long = 0
    var url = "https://firebasestorage.googleapis.com/v0/b/push-notifications-32c15.appspot.com/o/video%2F%D8%B4%D8%A7%D8%B1%D8%A9%20%D8%A8%D8%A7%D8%A8%D8%A7%D8%B1%20%D9%81%D9%8A%D9%84%20_%20%D8%B7%D8%A7%D8%B1%D9%82%20%D8%A7%D9%84%D8%B9%D8%B1%D8%A8%D9%8A%20%D8%B7%D8%B1%D9%82%D8%A7%D9%86.mp4?alt=media&token=d67afa72-1fe6-467a-9800-14813ef3dafc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viedo2)
        playerView = findViewById(R.id.video_view2)
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