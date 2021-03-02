package android.support.p000v4.media;

import android.os.SystemClock;
import android.support.p003v7.appcompat.C0137R;
import android.view.KeyEvent;

/* renamed from: android.support.v4.media.TransportPerformer */
public abstract class TransportPerformer {
    static final int AUDIOFOCUS_GAIN = 1;
    static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    static final int AUDIOFOCUS_LOSS = -1;
    static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
    static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;

    public void onAudioFocusChange(int i) {
        char c = 0;
        switch (i) {
            case -1:
                c = 127;
                break;
        }
        if (c != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            onMediaButtonDown(TransportMediator.KEYCODE_MEDIA_PAUSE, new KeyEvent(uptimeMillis, uptimeMillis, 0, TransportMediator.KEYCODE_MEDIA_PAUSE, 0));
            onMediaButtonUp(TransportMediator.KEYCODE_MEDIA_PAUSE, new KeyEvent(uptimeMillis, uptimeMillis, 1, TransportMediator.KEYCODE_MEDIA_PAUSE, 0));
        }
    }

    public int onGetBufferPercentage() {
        return 100;
    }

    public abstract long onGetCurrentPosition();

    public abstract long onGetDuration();

    public int onGetTransportControlFlags() {
        return 60;
    }

    public abstract boolean onIsPlaying();

    public boolean onMediaButtonDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case C0137R.styleable.Theme_panelMenuListTheme /*79*/:
            case C0137R.styleable.Theme_colorControlActivated /*85*/:
                if (!onIsPlaying()) {
                    onStart();
                    break;
                } else {
                    onPause();
                    break;
                }
            case C0137R.styleable.Theme_colorControlHighlight /*86*/:
                onStop();
                break;
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
                onStart();
                break;
            case TransportMediator.KEYCODE_MEDIA_PAUSE /*127*/:
                onPause();
                break;
        }
        return true;
    }

    public boolean onMediaButtonUp(int i, KeyEvent keyEvent) {
        return true;
    }

    public abstract void onPause();

    public abstract void onSeekTo(long j);

    public abstract void onStart();

    public abstract void onStop();
}
