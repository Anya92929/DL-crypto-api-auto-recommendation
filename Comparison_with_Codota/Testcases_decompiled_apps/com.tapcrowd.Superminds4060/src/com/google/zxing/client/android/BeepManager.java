package com.google.zxing.client.android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.IOException;

final class BeepManager implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    private static final float BEEP_VOLUME = 0.1f;
    private static final String TAG = BeepManager.class.getSimpleName();
    private static final long VIBRATE_DURATION = 200;
    private final Activity activity;
    private MediaPlayer mediaPlayer = null;
    private boolean playBeep;
    private boolean vibrate;

    BeepManager(Activity activity2) {
        this.activity = activity2;
        updatePrefs();
    }

    /* access modifiers changed from: package-private */
    public synchronized void updatePrefs() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.activity);
        this.playBeep = shouldBeep(prefs, this.activity);
        this.vibrate = prefs.getBoolean(PreferencesActivity.KEY_VIBRATE, false);
        if (this.playBeep && this.mediaPlayer == null) {
            this.activity.setVolumeControlStream(3);
            this.mediaPlayer = buildMediaPlayer(this.activity);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void playBeepSoundAndVibrate() {
        if (this.playBeep && this.mediaPlayer != null) {
            this.mediaPlayer.start();
        }
        if (this.vibrate) {
            ((Vibrator) this.activity.getSystemService("vibrator")).vibrate(VIBRATE_DURATION);
        }
    }

    private static boolean shouldBeep(SharedPreferences prefs, Context activity2) {
        boolean shouldPlayBeep = prefs.getBoolean(PreferencesActivity.KEY_PLAY_BEEP, true);
        if (!shouldPlayBeep || ((AudioManager) activity2.getSystemService("audio")).getRingerMode() == 2) {
            return shouldPlayBeep;
        }
        return false;
    }

    private MediaPlayer buildMediaPlayer(Context activity2) {
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        mediaPlayer2.setAudioStreamType(3);
        mediaPlayer2.setOnCompletionListener(this);
        mediaPlayer2.setOnErrorListener(this);
        AssetFileDescriptor file = activity2.getResources().openRawResourceFd(C0776R.raw.beep);
        try {
            mediaPlayer2.setDataSource(file.getFileDescriptor(), file.getStartOffset(), file.getLength());
            file.close();
            mediaPlayer2.setVolume(BEEP_VOLUME, BEEP_VOLUME);
            mediaPlayer2.prepare();
            return mediaPlayer2;
        } catch (IOException ioe) {
            Log.w(TAG, ioe);
            return null;
        }
    }

    public void onCompletion(MediaPlayer mp) {
        mp.seekTo(0);
    }

    public synchronized boolean onError(MediaPlayer mp, int what, int extra) {
        if (what == 100) {
            this.activity.finish();
        } else {
            mp.release();
            this.mediaPlayer = null;
            updatePrefs();
        }
        return true;
    }
}
