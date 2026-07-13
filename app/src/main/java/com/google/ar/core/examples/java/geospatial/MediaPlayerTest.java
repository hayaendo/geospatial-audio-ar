package com.google.ar.core.examples.java.geospatial;

import android.content.Context;
import android.media.MediaPlayer;

public class MediaPlayerTest implements MediaPlayer.OnCompletionListener {

    private Context mContext;
    private MediaPlayer mMediaPlayer;

    public MediaPlayerTest(Context context) {
        mContext = context;
        mMediaPlayer = null;
    }

    /**
     * 再生開始
     * @param resourceId 音源のリソースID (例: R.raw.point_a)
     */
    public void start(int resourceId) {
        // すでに再生中のものがあれば解放
        stop();

        // 指定されたIDでプレイヤーを作成
        mMediaPlayer = MediaPlayer.create(mContext, resourceId);

        if (mMediaPlayer == null) {
            return;
        }

        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.start();
    }

    public void stop() {
        if (mMediaPlayer != null) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
            }
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public void setLooping(boolean bool) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setLooping(bool);
        }
    }

    public boolean isPlaying() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.isPlaying();
        }
        return false;
    }

    public void setVolume(float leftVolume, float rightVolume) {
        if (mMediaPlayer != null) {
            mMediaPlayer.setVolume(leftVolume, rightVolume);
        }
    }

    //ID取得(イコライザー)
    public int getAudioSessionId() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.getAudioSessionId();
        }
        return 0;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stop();
    }
}