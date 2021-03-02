package android.support.p000v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2 */
class TransportMediatorJellybeanMR2 implements RemoteControlClient.OnGetPlaybackPositionListener, RemoteControlClient.OnPlaybackPositionUpdateListener {

    /* renamed from: a */
    final Context f862a;

    /* renamed from: b */
    final AudioManager f863b;

    /* renamed from: c */
    final View f864c;

    /* renamed from: d */
    final TransportMediatorCallback f865d;

    /* renamed from: e */
    final String f866e;

    /* renamed from: f */
    final IntentFilter f867f;

    /* renamed from: g */
    final Intent f868g;

    /* renamed from: h */
    final ViewTreeObserver.OnWindowAttachListener f869h = new ViewTreeObserver.OnWindowAttachListener() {
        public void onWindowAttached() {
            TransportMediatorJellybeanMR2.this.mo1434a();
        }

        public void onWindowDetached() {
            TransportMediatorJellybeanMR2.this.mo1440f();
        }
    };

    /* renamed from: i */
    final ViewTreeObserver.OnWindowFocusChangeListener f870i = new ViewTreeObserver.OnWindowFocusChangeListener() {
        public void onWindowFocusChanged(boolean z) {
            if (z) {
                TransportMediatorJellybeanMR2.this.mo1435b();
            } else {
                TransportMediatorJellybeanMR2.this.mo1439e();
            }
        }
    };

    /* renamed from: j */
    final BroadcastReceiver f871j = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                TransportMediatorJellybeanMR2.this.f865d.handleKey((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (ClassCastException e) {
                Log.w("TransportController", e);
            }
        }
    };

    /* renamed from: k */
    AudioManager.OnAudioFocusChangeListener f872k = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i) {
            TransportMediatorJellybeanMR2.this.f865d.handleAudioFocusChange(i);
        }
    };

    /* renamed from: l */
    PendingIntent f873l;

    /* renamed from: m */
    RemoteControlClient f874m;

    /* renamed from: n */
    boolean f875n;

    /* renamed from: o */
    int f876o = 0;

    /* renamed from: p */
    boolean f877p;

    public TransportMediatorJellybeanMR2(Context context, AudioManager audioManager, View view, TransportMediatorCallback transportMediatorCallback) {
        this.f862a = context;
        this.f863b = audioManager;
        this.f864c = view;
        this.f865d = transportMediatorCallback;
        this.f866e = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.f868g = new Intent(this.f866e);
        this.f868g.setPackage(context.getPackageName());
        this.f867f = new IntentFilter();
        this.f867f.addAction(this.f866e);
        this.f864c.getViewTreeObserver().addOnWindowAttachListener(this.f869h);
        this.f864c.getViewTreeObserver().addOnWindowFocusChangeListener(this.f870i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1434a() {
        this.f862a.registerReceiver(this.f871j, this.f867f);
        this.f873l = PendingIntent.getBroadcast(this.f862a, 0, this.f868g, 268435456);
        this.f874m = new RemoteControlClient(this.f873l);
        this.f874m.setOnGetPlaybackPositionListener(this);
        this.f874m.setPlaybackPositionUpdateListener(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1435b() {
        if (!this.f875n) {
            this.f875n = true;
            this.f863b.registerMediaButtonEventReceiver(this.f873l);
            this.f863b.registerRemoteControlClient(this.f874m);
            if (this.f876o == 3) {
                mo1436c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1436c() {
        if (!this.f877p) {
            this.f877p = true;
            this.f863b.requestAudioFocus(this.f872k, 3, 1);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo1437d() {
        if (this.f877p) {
            this.f877p = false;
            this.f863b.abandonAudioFocus(this.f872k);
        }
    }

    public void destroy() {
        mo1440f();
        this.f864c.getViewTreeObserver().removeOnWindowAttachListener(this.f869h);
        this.f864c.getViewTreeObserver().removeOnWindowFocusChangeListener(this.f870i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo1439e() {
        mo1437d();
        if (this.f875n) {
            this.f875n = false;
            this.f863b.unregisterRemoteControlClient(this.f874m);
            this.f863b.unregisterMediaButtonEventReceiver(this.f873l);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo1440f() {
        mo1439e();
        if (this.f873l != null) {
            this.f862a.unregisterReceiver(this.f871j);
            this.f873l.cancel();
            this.f873l = null;
            this.f874m = null;
        }
    }

    public Object getRemoteControlClient() {
        return this.f874m;
    }

    public long onGetPlaybackPosition() {
        return this.f865d.getPlaybackPosition();
    }

    public void onPlaybackPositionUpdate(long j) {
        this.f865d.playbackPositionUpdate(j);
    }

    public void pausePlaying() {
        if (this.f876o == 3) {
            this.f876o = 2;
            this.f874m.setPlaybackState(2);
        }
        mo1437d();
    }

    public void refreshState(boolean z, long j, int i) {
        if (this.f874m != null) {
            this.f874m.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : BitmapDescriptorFactory.HUE_RED);
            this.f874m.setTransportControlFlags(i);
        }
    }

    public void startPlaying() {
        if (this.f876o != 3) {
            this.f876o = 3;
            this.f874m.setPlaybackState(3);
        }
        if (this.f875n) {
            mo1436c();
        }
    }

    public void stopPlaying() {
        if (this.f876o != 1) {
            this.f876o = 1;
            this.f874m.setPlaybackState(1);
        }
        mo1437d();
    }
}
