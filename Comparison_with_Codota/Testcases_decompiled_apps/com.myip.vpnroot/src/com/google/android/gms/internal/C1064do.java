package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.android.gms.tagmanager.DataLayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.do */
public final class C1064do extends FrameLayout implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* renamed from: md */
    private final C1232gv f3189md;

    /* renamed from: rX */
    private final MediaController f3190rX;

    /* renamed from: rY */
    private final C1065a f3191rY = new C1065a(this);

    /* renamed from: rZ */
    private final VideoView f3192rZ;

    /* renamed from: sa */
    private long f3193sa;

    /* renamed from: sb */
    private String f3194sb;

    /* renamed from: com.google.android.gms.internal.do$a */
    private static final class C1065a {

        /* renamed from: mk */
        private final Runnable f3195mk;
        /* access modifiers changed from: private */

        /* renamed from: sc */
        public volatile boolean f3196sc = false;

        public C1065a(final C1064do doVar) {
            this.f3195mk = new Runnable() {

                /* renamed from: sd */
                private final WeakReference<C1064do> f3197sd = new WeakReference<>(doVar);

                public void run() {
                    C1064do doVar = (C1064do) this.f3197sd.get();
                    if (!C1065a.this.f3196sc && doVar != null) {
                        doVar.mo8347cj();
                        C1065a.this.mo8357ck();
                    }
                }
            };
        }

        public void cancel() {
            this.f3196sc = true;
            C1228gr.f3776wC.removeCallbacks(this.f3195mk);
        }

        /* renamed from: ck */
        public void mo8357ck() {
            C1228gr.f3776wC.postDelayed(this.f3195mk, 250);
        }
    }

    public C1064do(Context context, C1232gv gvVar) {
        super(context);
        this.f3189md = gvVar;
        this.f3192rZ = new VideoView(context);
        addView(this.f3192rZ, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f3190rX = new MediaController(context);
        this.f3191rY.mo8357ck();
        this.f3192rZ.setOnCompletionListener(this);
        this.f3192rZ.setOnPreparedListener(this);
        this.f3192rZ.setOnErrorListener(this);
    }

    /* renamed from: a */
    private static void m4261a(C1232gv gvVar, String str) {
        m4264a(gvVar, str, (Map<String, String>) new HashMap(1));
    }

    /* renamed from: a */
    public static void m4262a(C1232gv gvVar, String str, String str2) {
        boolean z = str2 == null;
        HashMap hashMap = new HashMap(z ? 2 : 3);
        hashMap.put("what", str);
        if (!z) {
            hashMap.put("extra", str2);
        }
        m4264a(gvVar, "error", (Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private static void m4263a(C1232gv gvVar, String str, String str2, String str3) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        m4264a(gvVar, str, (Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private static void m4264a(C1232gv gvVar, String str, Map<String, String> map) {
        map.put(DataLayer.EVENT_KEY, str);
        gvVar.mo8622a("onVideoEvent", (Map<String, ?>) map);
    }

    /* renamed from: C */
    public void mo8344C(String str) {
        this.f3194sb = str;
    }

    /* renamed from: b */
    public void mo8345b(MotionEvent motionEvent) {
        this.f3192rZ.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: ci */
    public void mo8346ci() {
        if (!TextUtils.isEmpty(this.f3194sb)) {
            this.f3192rZ.setVideoPath(this.f3194sb);
        } else {
            m4262a(this.f3189md, "no_src", (String) null);
        }
    }

    /* renamed from: cj */
    public void mo8347cj() {
        long currentPosition = (long) this.f3192rZ.getCurrentPosition();
        if (this.f3193sa != currentPosition) {
            m4263a(this.f3189md, "timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.f3193sa = currentPosition;
        }
    }

    public void destroy() {
        this.f3191rY.cancel();
        this.f3192rZ.stopPlayback();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m4261a(this.f3189md, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        m4262a(this.f3189md, String.valueOf(what), String.valueOf(extra));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        m4263a(this.f3189md, "canplaythrough", "duration", String.valueOf(((float) this.f3192rZ.getDuration()) / 1000.0f));
    }

    public void pause() {
        this.f3192rZ.pause();
    }

    public void play() {
        this.f3192rZ.start();
    }

    /* renamed from: q */
    public void mo8354q(boolean z) {
        if (z) {
            this.f3192rZ.setMediaController(this.f3190rX);
            return;
        }
        this.f3190rX.hide();
        this.f3192rZ.setMediaController((MediaController) null);
    }

    public void seekTo(int timeInMilliseconds) {
        this.f3192rZ.seekTo(timeInMilliseconds);
    }
}
