package com.example.androidtestingdemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;


public class VideoActivity extends Activity {

    private SimpleExoPlayer player;
    private  PlayerView playerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);
        playerView =  findViewById(R.id.video_view);
        initializePlayer();
    }

    private void initializePlayer() {

        player = new SimpleExoPlayer.Builder(this).build();
            playerView.setPlayer(player);

        // Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "yourApplicationName"));
// This is the MediaSource representing the media to be played.

        Uri uri = Uri.parse("http://k12-fang.oss-cn-shanghai.aliyuncs.com/public/15842560850429152.mp4?Expires=1590842675&OSSAccessKeyId=LTAI4FuC6XenJiUJSgSfAKM9&Signature=nGb7hb1M1giULrNlThVIxEuRpy4%3D");

        MediaSource videoSource =
                new ProgressiveMediaSource.Factory(dataSourceFactory)
                        .createMediaSource(uri);
// Prepare the player with the source.
        player.prepare(videoSource);


        player.prepare(videoSource, false, true);
    }

}
