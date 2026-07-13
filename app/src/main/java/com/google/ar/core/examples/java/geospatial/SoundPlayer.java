package com.google.ar.core.examples.java.geospatial;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class SoundPlayer {
    private static SoundPool soundPool;
    private static int farSound;
    private static int nearSound;

    private AudioAttributes audioAttributes;

    public SoundPlayer(Context context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(2)
                    .build();
        } else {
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        }

//        farSound = soundPool.load(context, R.raw.far, 1);
//        nearSound = soundPool.load(context, R.raw.near, 1);
    }

    public void playFarSound() {
        soundPool.play(farSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playNearSound() {
        soundPool.play(nearSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
