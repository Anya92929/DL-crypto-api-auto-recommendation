package android.support.p000v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.support.p000v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import java.util.ArrayList;

/* renamed from: android.support.v4.media.TransportMediator */
public class TransportMediator extends TransportController {
    public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
    public static final int FLAG_KEY_MEDIA_NEXT = 128;
    public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    public static final int FLAG_KEY_MEDIA_PLAY = 4;
    public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    public static final int FLAG_KEY_MEDIA_REWIND = 2;
    public static final int FLAG_KEY_MEDIA_STOP = 32;
    public static final int KEYCODE_MEDIA_PAUSE = 127;
    public static final int KEYCODE_MEDIA_PLAY = 126;
    public static final int KEYCODE_MEDIA_RECORD = 130;

    /* renamed from: a */
    final Context f851a;

    /* renamed from: b */
    final TransportPerformer f852b;

    /* renamed from: c */
    final AudioManager f853c;

    /* renamed from: d */
    final View f854d;

    /* renamed from: e */
    final Object f855e;

    /* renamed from: f */
    final TransportMediatorJellybeanMR2 f856f;

    /* renamed from: g */
    final ArrayList<TransportStateListener> f857g;

    /* renamed from: h */
    final TransportMediatorCallback f858h;

    /* renamed from: i */
    final KeyEvent.Callback f859i;

    public TransportMediator(Activity activity, TransportPerformer transportPerformer) {
        this(activity, (View) null, transportPerformer);
    }

    private TransportMediator(Activity activity, View view, TransportPerformer transportPerformer) {
        this.f857g = new ArrayList<>();
        this.f858h = new TransportMediatorCallback() {
            public long getPlaybackPosition() {
                return TransportMediator.this.f852b.onGetCurrentPosition();
            }

            public void handleAudioFocusChange(int i) {
                TransportMediator.this.f852b.onAudioFocusChange(i);
            }

            public void handleKey(KeyEvent keyEvent) {
                keyEvent.dispatch(TransportMediator.this.f859i);
            }

            public void playbackPositionUpdate(long j) {
                TransportMediator.this.f852b.onSeekTo(j);
            }
        };
        this.f859i = new KeyEvent.Callback() {
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                if (TransportMediator.m677a(i)) {
                    return TransportMediator.this.f852b.onMediaButtonDown(i, keyEvent);
                }
                return false;
            }

            public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
                return false;
            }

            public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
                return false;
            }

            public boolean onKeyUp(int i, KeyEvent keyEvent) {
                if (TransportMediator.m677a(i)) {
                    return TransportMediator.this.f852b.onMediaButtonUp(i, keyEvent);
                }
                return false;
            }
        };
        this.f851a = activity != null ? activity : view.getContext();
        this.f852b = transportPerformer;
        this.f853c = (AudioManager) this.f851a.getSystemService("audio");
        this.f854d = activity != null ? activity.getWindow().getDecorView() : view;
        this.f855e = KeyEventCompat.getKeyDispatcherState(this.f854d);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f856f = new TransportMediatorJellybeanMR2(this.f851a, this.f853c, this.f854d, this.f858h);
        } else {
            this.f856f = null;
        }
    }

    public TransportMediator(View view, TransportPerformer transportPerformer) {
        this((Activity) null, view, transportPerformer);
    }

    /* renamed from: a */
    static boolean m677a(int i) {
        switch (i) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case KEYCODE_MEDIA_RECORD /*130*/:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    private TransportStateListener[] m678a() {
        if (this.f857g.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.f857g.size()];
        this.f857g.toArray(transportStateListenerArr);
        return transportStateListenerArr;
    }

    /* renamed from: b */
    private void m679b() {
        TransportStateListener[] a = m678a();
        if (a != null) {
            for (TransportStateListener onPlayingChanged : a) {
                onPlayingChanged.onPlayingChanged(this);
            }
        }
    }

    /* renamed from: c */
    private void m680c() {
        TransportStateListener[] a = m678a();
        if (a != null) {
            for (TransportStateListener onTransportControlsChanged : a) {
                onTransportControlsChanged.onTransportControlsChanged(this);
            }
        }
    }

    /* renamed from: d */
    private void m681d() {
        if (this.f856f != null) {
            this.f856f.refreshState(this.f852b.onIsPlaying(), this.f852b.onGetCurrentPosition(), this.f852b.onGetTransportControlFlags());
        }
    }

    public void destroy() {
        this.f856f.destroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventCompat.dispatch(keyEvent, this.f859i, this.f855e, this);
    }

    public int getBufferPercentage() {
        return this.f852b.onGetBufferPercentage();
    }

    public long getCurrentPosition() {
        return this.f852b.onGetCurrentPosition();
    }

    public long getDuration() {
        return this.f852b.onGetDuration();
    }

    public Object getRemoteControlClient() {
        if (this.f856f != null) {
            return this.f856f.getRemoteControlClient();
        }
        return null;
    }

    public int getTransportControlFlags() {
        return this.f852b.onGetTransportControlFlags();
    }

    public boolean isPlaying() {
        return this.f852b.onIsPlaying();
    }

    public void pausePlaying() {
        if (this.f856f != null) {
            this.f856f.pausePlaying();
        }
        this.f852b.onPause();
        m681d();
        m679b();
    }

    public void refreshState() {
        m681d();
        m679b();
        m680c();
    }

    public void registerStateListener(TransportStateListener transportStateListener) {
        this.f857g.add(transportStateListener);
    }

    public void seekTo(long j) {
        this.f852b.onSeekTo(j);
    }

    public void startPlaying() {
        if (this.f856f != null) {
            this.f856f.startPlaying();
        }
        this.f852b.onStart();
        m681d();
        m679b();
    }

    public void stopPlaying() {
        if (this.f856f != null) {
            this.f856f.stopPlaying();
        }
        this.f852b.onStop();
        m681d();
        m679b();
    }

    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.f857g.remove(transportStateListener);
    }
}
