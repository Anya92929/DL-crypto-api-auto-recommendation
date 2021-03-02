package com.google.ads.internal;

import android.app.Activity;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.ads.C0265m;
import com.google.ads.util.C0284b;
import java.lang.ref.WeakReference;

public class AdVideoView extends FrameLayout implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* renamed from: b */
    private static final C0232a f458b = C0232a.f474a.mo3484b();

    /* renamed from: a */
    public MediaController f459a = null;

    /* renamed from: c */
    private final WeakReference<Activity> f460c;

    /* renamed from: d */
    private final AdWebView f461d;

    /* renamed from: e */
    private long f462e = 0;

    /* renamed from: f */
    private final VideoView f463f;

    /* renamed from: g */
    private String f464g = null;

    /* renamed from: com.google.ads.internal.AdVideoView$a */
    private static class C0229a implements Runnable {

        /* renamed from: a */
        private final WeakReference<AdVideoView> f465a;

        public C0229a(AdVideoView adVideoView) {
            this.f465a = new WeakReference<>(adVideoView);
        }

        public void run() {
            AdVideoView adVideoView = (AdVideoView) this.f465a.get();
            if (adVideoView == null) {
                C0284b.m488d("The video must be gone, so cancelling the timeupdate task.");
                return;
            }
            adVideoView.mo3446f();
            C0265m.m411a().f617c.mo3725a().postDelayed(this, 250);
        }

        /* renamed from: a */
        public void mo3452a() {
            C0265m.m411a().f617c.mo3725a().postDelayed(this, 250);
        }
    }

    public AdVideoView(Activity adActivity, AdWebView adWebView) {
        super(adActivity);
        this.f460c = new WeakReference<>(adActivity);
        this.f461d = adWebView;
        this.f463f = new VideoView(adActivity);
        addView(this.f463f, new FrameLayout.LayoutParams(-1, -1, 17));
        mo3439a();
        this.f463f.setOnCompletionListener(this);
        this.f463f.setOnPreparedListener(this);
        this.f463f.setOnErrorListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3439a() {
        new C0229a(this).mo3452a();
    }

    /* renamed from: b */
    public void mo3442b() {
        if (!TextUtils.isEmpty(this.f464g)) {
            this.f463f.setVideoPath(this.f464g);
        } else {
            f458b.mo3476a(this.f461d, "onVideoEvent", "{'event': 'error', 'what': 'no_src'}");
        }
    }

    public void setMediaControllerEnabled(boolean enabled) {
        Activity activity = (Activity) this.f460c.get();
        if (activity == null) {
            C0284b.m490e("adActivity was null while trying to enable controls on a video.");
        } else if (enabled) {
            if (this.f459a == null) {
                this.f459a = new MediaController(activity);
            }
            this.f463f.setMediaController(this.f459a);
        } else {
            if (this.f459a != null) {
                this.f459a.hide();
            }
            this.f463f.setMediaController((MediaController) null);
        }
    }

    public void setSrc(String src) {
        this.f464g = src;
    }

    public void onCompletion(MediaPlayer mp) {
        f458b.mo3476a(this.f461d, "onVideoEvent", "{'event': 'ended'}");
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        C0284b.m490e("Video threw error! <what:" + what + ", extra:" + extra + ">");
        f458b.mo3476a(this.f461d, "onVideoEvent", "{'event': 'error', 'what': '" + what + "', 'extra': '" + extra + "'}");
        return true;
    }

    public void onPrepared(MediaPlayer mp) {
        f458b.mo3476a(this.f461d, "onVideoEvent", "{'event': 'canplaythrough', 'duration': '" + (((float) this.f463f.getDuration()) / 1000.0f) + "'}");
    }

    /* renamed from: c */
    public void mo3443c() {
        this.f463f.pause();
    }

    /* renamed from: d */
    public void mo3444d() {
        this.f463f.start();
    }

    /* renamed from: a */
    public void mo3440a(int i) {
        this.f463f.seekTo(i);
    }

    /* renamed from: a */
    public void mo3441a(MotionEvent motionEvent) {
        this.f463f.onTouchEvent(motionEvent);
    }

    /* renamed from: e */
    public void mo3445e() {
        this.f463f.stopPlayback();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo3446f() {
        long currentPosition = (long) this.f463f.getCurrentPosition();
        if (this.f462e != currentPosition) {
            f458b.mo3476a(this.f461d, "onVideoEvent", "{'event': 'timeupdate', 'time': " + (((float) currentPosition) / 1000.0f) + "}");
            this.f462e = currentPosition;
        }
    }
}
