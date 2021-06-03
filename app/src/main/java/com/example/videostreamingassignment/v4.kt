package com.example.videostreamingassignment

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class v4 : AppCompatActivity() {
    lateinit var playerView: PlayerView
    var player: SimpleExoPlayer? = null

    var playWhenReady = true
    var currentWindow = 0
    var playBackPosition: Long = 0
    var url = "https://firebasestorage.googleapis.com/v0/b/push-notifications-32c15.appspot.com/o/video%2FErste%20Christmas%20Ad%202018_%20What%20would%20Christmas%20be%20without%20love_.mp4?alt=media&token=80849dae-941c-4ddc-8941-ab945e763a89"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_v4)
        playerView = findViewById(R.id.video_view4)
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