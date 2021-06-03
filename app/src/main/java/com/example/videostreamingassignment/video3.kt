package com.example.videostreamingassignment

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class video3 : AppCompatActivity() {
    lateinit var playerView: PlayerView
    var player: SimpleExoPlayer? = null

    var playWhenReady = true
    var currentWindow = 0
    var playBackPosition: Long = 0
    var url = "https://firebasestorage.googleapis.com/v0/b/push-notifications-32c15.appspot.com/o/video%2FFragmentos%20-%20para%20pensar%20habilidades%20socioemocionais.mp4?alt=media&token=f1966acf-2476-429d-ac6e-3a28c3e49e58"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video3)
        playerView = findViewById(R.id.video_view3)
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