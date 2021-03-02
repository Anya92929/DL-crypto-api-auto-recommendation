package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.android.gcm.GCMConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.cordova.Globalization;

/* renamed from: com.google.android.gms.internal.bj */
public final class C0287bj extends FrameLayout implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* renamed from: fG */
    private final C0347cq f872fG;

    /* renamed from: gb */
    private final MediaController f873gb;

    /* renamed from: gc */
    private final C0288a f874gc = new C0288a(this);

    /* renamed from: gd */
    private final VideoView f875gd;

    /* renamed from: ge */
    private long f876ge;

    /* renamed from: gf */
    private String f877gf;

    /* renamed from: com.google.android.gms.internal.bj$a */
    private static final class C0288a {

        /* renamed from: el */
        private final Runnable f878el;
        /* access modifiers changed from: private */

        /* renamed from: gg */
        public volatile boolean f879gg = false;

        public C0288a(final C0287bj bjVar) {
            this.f878el = new Runnable() {

                /* renamed from: gh */
                private final WeakReference<C0287bj> f880gh = new WeakReference<>(bjVar);

                public void run() {
                    C0287bj bjVar = (C0287bj) this.f880gh.get();
                    if (!C0288a.this.f879gg && bjVar != null) {
                        bjVar.mo4129aa();
                        C0288a.this.mo4140ab();
                    }
                }
            };
        }

        /* renamed from: ab */
        public void mo4140ab() {
            C0343cm.f1013hO.postDelayed(this.f878el, 250);
        }

        public void cancel() {
            this.f879gg = true;
            C0343cm.f1013hO.removeCallbacks(this.f878el);
        }
    }

    public C0287bj(Context context, C0347cq cqVar) {
        super(context);
        this.f872fG = cqVar;
        this.f875gd = new VideoView(context);
        addView(this.f875gd, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f873gb = new MediaController(context);
        this.f874gc.mo4140ab();
        this.f875gd.setOnCompletionListener(this);
        this.f875gd.setOnPreparedListener(this);
        this.f875gd.setOnErrorListener(this);
    }

    /* renamed from: a */
    private static void m589a(C0347cq cqVar, String str) {
        m592a(cqVar, str, (Map<String, String>) new HashMap(1));
    }

    /* renamed from: a */
    public static void m590a(C0347cq cqVar, String str, String str2) {
        boolean z = str2 == null;
        HashMap hashMap = new HashMap(z ? 2 : 3);
        hashMap.put("what", str);
        if (!z) {
            hashMap.put("extra", str2);
        }
        m592a(cqVar, GCMConstants.EXTRA_ERROR, (Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private static void m591a(C0347cq cqVar, String str, String str2, String str3) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        m592a(cqVar, str, (Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private static void m592a(C0347cq cqVar, String str, Map<String, String> map) {
        map.put("event", str);
        cqVar.mo4207a("onVideoEvent", (Map<String, ?>) map);
    }

    /* renamed from: Z */
    public void mo4128Z() {
        if (!TextUtils.isEmpty(this.f877gf)) {
            this.f875gd.setVideoPath(this.f877gf);
        } else {
            m590a(this.f872fG, "no_src", (String) null);
        }
    }

    /* renamed from: aa */
    public void mo4129aa() {
        long currentPosition = (long) this.f875gd.getCurrentPosition();
        if (this.f876ge != currentPosition) {
            m591a(this.f872fG, "timeupdate", Globalization.TIME, String.valueOf(((float) currentPosition) / 1000.0f));
            this.f876ge = currentPosition;
        }
    }

    /* renamed from: b */
    public void mo4130b(MotionEvent motionEvent) {
        this.f875gd.dispatchTouchEvent(motionEvent);
    }

    public void destroy() {
        this.f874gc.cancel();
        this.f875gd.stopPlayback();
    }

    /* renamed from: f */
    public void mo4132f(boolean z) {
        if (z) {
            this.f875gd.setMediaController(this.f873gb);
            return;
        }
        this.f873gb.hide();
        this.f875gd.setMediaController((MediaController) null);
    }

    /* renamed from: i */
    public void mo4133i(String str) {
        this.f877gf = str;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m589a(this.f872fG, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        m590a(this.f872fG, String.valueOf(what), String.valueOf(extra));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        m591a(this.f872fG, "canplaythrough", "duration", String.valueOf(((float) this.f875gd.getDuration()) / 1000.0f));
    }

    public void pause() {
        this.f875gd.pause();
    }

    public void play() {
        this.f875gd.start();
    }

    public void seekTo(int timeInMilliseconds) {
        this.f875gd.seekTo(timeInMilliseconds);
    }
}
