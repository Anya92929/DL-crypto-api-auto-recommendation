package android.support.p001v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.support.p001v4.view.KeyEventCompat;
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
    final Context f633a;

    /* renamed from: b */
    final TransportPerformer f634b;

    /* renamed from: c */
    final AudioManager f635c;

    /* renamed from: d */
    final View f636d;

    /* renamed from: e */
    final Object f637e;

    /* renamed from: f */
    final C0628br f638f;

    /* renamed from: g */
    final ArrayList<TransportStateListener> f639g;

    /* renamed from: h */
    final C0627bq f640h;

    /* renamed from: i */
    final KeyEvent.Callback f641i;

    /* renamed from: a */
    static boolean m626a(int i) {
        switch (i) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case KEYCODE_MEDIA_PLAY /*126*/:
            case KEYCODE_MEDIA_PAUSE /*127*/:
            case KEYCODE_MEDIA_RECORD /*130*/:
                return true;
            default:
                return false;
        }
    }

    public TransportMediator(Activity activity, TransportPerformer transportPerformer) {
        this(activity, (View) null, transportPerformer);
    }

    public TransportMediator(View view, TransportPerformer transportPerformer) {
        this((Activity) null, view, transportPerformer);
    }

    private TransportMediator(Activity activity, View view, TransportPerformer transportPerformer) {
        this.f639g = new ArrayList<>();
        this.f640h = new C0627bq() {
            /* renamed from: a */
            public void mo1117a(KeyEvent keyEvent) {
                keyEvent.dispatch(TransportMediator.this.f641i);
            }

            /* renamed from: a */
            public void mo1115a(int i) {
                TransportMediator.this.f634b.onAudioFocusChange(i);
            }

            /* renamed from: a */
            public long mo1114a() {
                return TransportMediator.this.f634b.onGetCurrentPosition();
            }

            /* renamed from: a */
            public void mo1116a(long j) {
                TransportMediator.this.f634b.onSeekTo(j);
            }
        };
        this.f641i = new KeyEvent.Callback() {
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                if (TransportMediator.m626a(i)) {
                    return TransportMediator.this.f634b.onMediaButtonDown(i, keyEvent);
                }
                return false;
            }

            public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
                return false;
            }

            public boolean onKeyUp(int i, KeyEvent keyEvent) {
                if (TransportMediator.m626a(i)) {
                    return TransportMediator.this.f634b.onMediaButtonUp(i, keyEvent);
                }
                return false;
            }

            public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
                return false;
            }
        };
        this.f633a = activity != null ? activity : view.getContext();
        this.f634b = transportPerformer;
        this.f635c = (AudioManager) this.f633a.getSystemService("audio");
        this.f636d = activity != null ? activity.getWindow().getDecorView() : view;
        this.f637e = KeyEventCompat.getKeyDispatcherState(this.f636d);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f638f = new C0628br(this.f633a, this.f635c, this.f636d, this.f640h);
        } else {
            this.f638f = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.f638f != null) {
            return this.f638f.mo4701a();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventCompat.dispatch(keyEvent, this.f641i, this.f637e, this);
    }

    public void registerStateListener(TransportStateListener transportStateListener) {
        this.f639g.add(transportStateListener);
    }

    public void unregisterStateListener(TransportStateListener transportStateListener) {
        this.f639g.remove(transportStateListener);
    }

    /* renamed from: a */
    private TransportStateListener[] m627a() {
        if (this.f639g.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.f639g.size()];
        this.f639g.toArray(transportStateListenerArr);
        return transportStateListenerArr;
    }

    /* renamed from: b */
    private void m628b() {
        TransportStateListener[] a = m627a();
        if (a != null) {
            for (TransportStateListener onPlayingChanged : a) {
                onPlayingChanged.onPlayingChanged(this);
            }
        }
    }

    /* renamed from: c */
    private void m629c() {
        TransportStateListener[] a = m627a();
        if (a != null) {
            for (TransportStateListener onTransportControlsChanged : a) {
                onTransportControlsChanged.onTransportControlsChanged(this);
            }
        }
    }

    /* renamed from: d */
    private void m630d() {
        if (this.f638f != null) {
            this.f638f.mo4702a(this.f634b.onIsPlaying(), this.f634b.onGetCurrentPosition(), this.f634b.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        m630d();
        m628b();
        m629c();
    }

    public void startPlaying() {
        if (this.f638f != null) {
            this.f638f.mo4707f();
        }
        this.f634b.onStart();
        m630d();
        m628b();
    }

    public void pausePlaying() {
        if (this.f638f != null) {
            this.f638f.mo4708g();
        }
        this.f634b.onPause();
        m630d();
        m628b();
    }

    public void stopPlaying() {
        if (this.f638f != null) {
            this.f638f.mo4709h();
        }
        this.f634b.onStop();
        m630d();
        m628b();
    }

    public long getDuration() {
        return this.f634b.onGetDuration();
    }

    public long getCurrentPosition() {
        return this.f634b.onGetCurrentPosition();
    }

    public void seekTo(long j) {
        this.f634b.onSeekTo(j);
    }

    public boolean isPlaying() {
        return this.f634b.onIsPlaying();
    }

    public int getBufferPercentage() {
        return this.f634b.onGetBufferPercentage();
    }

    public int getTransportControlFlags() {
        return this.f634b.onGetTransportControlFlags();
    }

    public void destroy() {
        this.f638f.mo4703b();
    }
}
