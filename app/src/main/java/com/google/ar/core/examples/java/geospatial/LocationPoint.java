package com.google.ar.core.examples.java.geospatial;

import android.content.Context;
import android.media.audiofx.Equalizer;
import android.util.Log;

import com.google.ar.core.Anchor;

public class LocationPoint {
    private static final String TAG = "LocationPoint";

    //座標
    public double latitude;
    public double longitude;
    public double altitude;

    public int audioResourceId;

    //この地点に対応するARCoreアンカー(解決されるまでnull)
    public Anchor anchor;

    //音響
    public MediaPlayerTest mediaPlayer;
    public Equalizer equalizer;

    public boolean isMediaPlaying = false;
    public double currentVolume;

    //イコライザー
    public short highFreqBand = -1;
    public short minEQLevel = 0;

    //計算キャッシュ
    public double distance = 0;
    //カメラの向きと音源方向のなす角(度)。正面0°、真後ろ180°
    public double angleFromCamera = 0;

    public LocationPoint(Context context, double lat, double lon, double alt, int audioResId){
        this.latitude = lat;
        this.longitude = lon;
        this.altitude = alt;
        this.audioResourceId = audioResId;

        this.mediaPlayer = new MediaPlayerTest(context);
    }

    public void release() {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            if (equalizer != null) {
                equalizer.release();
                equalizer = null;
            }
        }catch (Exception e){
            Log.e(TAG,"Error releasing resources",e);
        }
        isMediaPlaying = false;
        highFreqBand = -1;
    }
}
