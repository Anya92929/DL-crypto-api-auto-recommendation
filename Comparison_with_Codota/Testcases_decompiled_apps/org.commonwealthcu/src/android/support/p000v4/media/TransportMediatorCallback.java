package android.support.p000v4.media;

import android.view.KeyEvent;

/* renamed from: android.support.v4.media.TransportMediatorCallback */
interface TransportMediatorCallback {
    long getPlaybackPosition();

    void handleAudioFocusChange(int i);

    void handleKey(KeyEvent keyEvent);

    void playbackPositionUpdate(long j);
}
