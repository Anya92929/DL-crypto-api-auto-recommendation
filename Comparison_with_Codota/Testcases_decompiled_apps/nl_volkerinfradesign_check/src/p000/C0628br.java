package p000;

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

/* renamed from: br */
public class C0628br {

    /* renamed from: a */
    final Context f2409a;

    /* renamed from: b */
    final AudioManager f2410b;

    /* renamed from: c */
    final View f2411c;

    /* renamed from: d */
    final C0627bq f2412d;

    /* renamed from: e */
    final String f2413e;

    /* renamed from: f */
    final IntentFilter f2414f;

    /* renamed from: g */
    final Intent f2415g;

    /* renamed from: h */
    final ViewTreeObserver.OnWindowAttachListener f2416h = new ViewTreeObserver.OnWindowAttachListener() {
        public void onWindowAttached() {
            C0628br.this.mo4704c();
        }

        public void onWindowDetached() {
            C0628br.this.mo4712k();
        }
    };

    /* renamed from: i */
    final ViewTreeObserver.OnWindowFocusChangeListener f2417i = new ViewTreeObserver.OnWindowFocusChangeListener() {
        public void onWindowFocusChanged(boolean z) {
            if (z) {
                C0628br.this.mo4705d();
            } else {
                C0628br.this.mo4711j();
            }
        }
    };

    /* renamed from: j */
    final BroadcastReceiver f2418j = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C0628br.this.f2412d.mo1117a((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (ClassCastException e) {
                Log.w("TransportController", e);
            }
        }
    };

    /* renamed from: k */
    AudioManager.OnAudioFocusChangeListener f2419k = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i) {
            C0628br.this.f2412d.mo1115a(i);
        }
    };

    /* renamed from: l */
    final RemoteControlClient.OnGetPlaybackPositionListener f2420l = new RemoteControlClient.OnGetPlaybackPositionListener() {
        public long onGetPlaybackPosition() {
            return C0628br.this.f2412d.mo1114a();
        }
    };

    /* renamed from: m */
    final RemoteControlClient.OnPlaybackPositionUpdateListener f2421m = new RemoteControlClient.OnPlaybackPositionUpdateListener() {
        public void onPlaybackPositionUpdate(long j) {
            C0628br.this.f2412d.mo1116a(j);
        }
    };

    /* renamed from: n */
    PendingIntent f2422n;

    /* renamed from: o */
    RemoteControlClient f2423o;

    /* renamed from: p */
    boolean f2424p;

    /* renamed from: q */
    int f2425q = 0;

    /* renamed from: r */
    boolean f2426r;

    public C0628br(Context context, AudioManager audioManager, View view, C0627bq bqVar) {
        this.f2409a = context;
        this.f2410b = audioManager;
        this.f2411c = view;
        this.f2412d = bqVar;
        this.f2413e = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.f2415g = new Intent(this.f2413e);
        this.f2415g.setPackage(context.getPackageName());
        this.f2414f = new IntentFilter();
        this.f2414f.addAction(this.f2413e);
        this.f2411c.getViewTreeObserver().addOnWindowAttachListener(this.f2416h);
        this.f2411c.getViewTreeObserver().addOnWindowFocusChangeListener(this.f2417i);
    }

    /* renamed from: a */
    public Object mo4701a() {
        return this.f2423o;
    }

    /* renamed from: b */
    public void mo4703b() {
        mo4712k();
        this.f2411c.getViewTreeObserver().removeOnWindowAttachListener(this.f2416h);
        this.f2411c.getViewTreeObserver().removeOnWindowFocusChangeListener(this.f2417i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4704c() {
        this.f2409a.registerReceiver(this.f2418j, this.f2414f);
        this.f2422n = PendingIntent.getBroadcast(this.f2409a, 0, this.f2415g, 268435456);
        this.f2423o = new RemoteControlClient(this.f2422n);
        this.f2423o.setOnGetPlaybackPositionListener(this.f2420l);
        this.f2423o.setPlaybackPositionUpdateListener(this.f2421m);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4705d() {
        if (!this.f2424p) {
            this.f2424p = true;
            this.f2410b.registerMediaButtonEventReceiver(this.f2422n);
            this.f2410b.registerRemoteControlClient(this.f2423o);
            if (this.f2425q == 3) {
                mo4706e();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo4706e() {
        if (!this.f2426r) {
            this.f2426r = true;
            this.f2410b.requestAudioFocus(this.f2419k, 3, 1);
        }
    }

    /* renamed from: f */
    public void mo4707f() {
        if (this.f2425q != 3) {
            this.f2425q = 3;
            this.f2423o.setPlaybackState(3);
        }
        if (this.f2424p) {
            mo4706e();
        }
    }

    /* renamed from: a */
    public void mo4702a(boolean z, long j, int i) {
        if (this.f2423o != null) {
            this.f2423o.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : BitmapDescriptorFactory.HUE_RED);
            this.f2423o.setTransportControlFlags(i);
        }
    }

    /* renamed from: g */
    public void mo4708g() {
        if (this.f2425q == 3) {
            this.f2425q = 2;
            this.f2423o.setPlaybackState(2);
        }
        mo4710i();
    }

    /* renamed from: h */
    public void mo4709h() {
        if (this.f2425q != 1) {
            this.f2425q = 1;
            this.f2423o.setPlaybackState(1);
        }
        mo4710i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo4710i() {
        if (this.f2426r) {
            this.f2426r = false;
            this.f2410b.abandonAudioFocus(this.f2419k);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo4711j() {
        mo4710i();
        if (this.f2424p) {
            this.f2424p = false;
            this.f2410b.unregisterRemoteControlClient(this.f2423o);
            this.f2410b.unregisterMediaButtonEventReceiver(this.f2422n);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo4712k() {
        mo4711j();
        if (this.f2422n != null) {
            this.f2409a.unregisterReceiver(this.f2418j);
            this.f2422n.cancel();
            this.f2422n = null;
            this.f2423o = null;
        }
    }
}
