package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.p009v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzlh;
import java.util.HashMap;
import java.util.Map;

@zzin
public class zzk extends FrameLayout implements zzh {

    /* renamed from: a */
    private final zzlh f3796a;

    /* renamed from: b */
    private final FrameLayout f3797b;

    /* renamed from: c */
    private final C1294r f3798c;

    /* renamed from: d */
    private zzi f3799d;

    /* renamed from: e */
    private boolean f3800e;

    /* renamed from: f */
    private boolean f3801f;

    /* renamed from: g */
    private TextView f3802g;

    /* renamed from: h */
    private long f3803h;

    /* renamed from: i */
    private long f3804i;

    /* renamed from: j */
    private String f3805j;

    /* renamed from: k */
    private String f3806k;

    public zzk(Context context, zzlh zzlh, int i, boolean z, zzdk zzdk, zzdi zzdi) {
        super(context);
        this.f3796a = zzlh;
        this.f3797b = new FrameLayout(context);
        addView(this.f3797b, new FrameLayout.LayoutParams(-1, -1));
        zzb.zzu(zzlh.zzug());
        this.f3799d = zzlh.zzug().zzakk.zza(context, zzlh, i, z, zzdk, zzdi);
        if (this.f3799d != null) {
            this.f3797b.addView(this.f3799d, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        this.f3802g = new TextView(context);
        this.f3802g.setBackgroundColor(-16777216);
        m5676b();
        this.f3798c = new C1294r(this);
        this.f3798c.mo5427b();
        if (this.f3799d != null) {
            this.f3799d.zza((zzh) this);
        }
        if (this.f3799d == null) {
            zzl("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5675a(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        int length = strArr.length;
        int i = 0;
        String str2 = null;
        while (i < length) {
            String str3 = strArr[i];
            if (str2 != null) {
                hashMap.put(str2, str3);
                str3 = null;
            }
            i++;
            str2 = str3;
        }
        this.f3796a.zza("onVideoEvent", (Map) hashMap);
    }

    /* renamed from: b */
    private void m5676b() {
        if (!m5678d()) {
            this.f3797b.addView(this.f3802g, new FrameLayout.LayoutParams(-1, -1));
            this.f3797b.bringChildToFront(this.f3802g);
        }
    }

    /* renamed from: c */
    private void m5677c() {
        if (m5678d()) {
            this.f3797b.removeView(this.f3802g);
        }
    }

    /* renamed from: d */
    private boolean m5678d() {
        return this.f3802g.getParent() != null;
    }

    /* renamed from: e */
    private void m5679e() {
        if (this.f3796a.zzue() != null && !this.f3800e) {
            this.f3801f = (this.f3796a.zzue().getWindow().getAttributes().flags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
            if (!this.f3801f) {
                this.f3796a.zzue().getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
                this.f3800e = true;
            }
        }
    }

    /* renamed from: f */
    private void m5680f() {
        if (this.f3796a.zzue() != null && this.f3800e && !this.f3801f) {
            this.f3796a.zzue().getWindow().clearFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
            this.f3800e = false;
        }
    }

    public static void zzh(zzlh zzlh) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzlh.zza("onVideoEvent", (Map) hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5512a() {
        if (this.f3799d != null) {
            long currentPosition = (long) this.f3799d.getCurrentPosition();
            if (this.f3803h != currentPosition && currentPosition > 0) {
                m5677c();
                m5675a("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
                this.f3803h = currentPosition;
            }
        }
    }

    public void destroy() {
        this.f3798c.mo5426a();
        if (this.f3799d != null) {
            this.f3799d.stop();
        }
        m5680f();
    }

    public void onPaused() {
        m5675a("pause", new String[0]);
        m5680f();
    }

    public void pause() {
        if (this.f3799d != null) {
            this.f3799d.pause();
        }
    }

    public void play() {
        if (this.f3799d != null) {
            this.f3799d.play();
        }
    }

    public void seekTo(int i) {
        if (this.f3799d != null) {
            this.f3799d.seekTo(i);
        }
    }

    public void setMimeType(String str) {
        this.f3805j = str;
    }

    public void zza(float f) {
        if (this.f3799d != null) {
            this.f3799d.zza(f);
        }
    }

    public void zza(float f, float f2) {
        if (this.f3799d != null) {
            this.f3799d.zza(f, f2);
        }
    }

    public void zzbw(String str) {
        this.f3806k = str;
    }

    public void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3 + 2, i4 + 2);
            layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
            this.f3797b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public void zzd(MotionEvent motionEvent) {
        if (this.f3799d != null) {
            this.f3799d.dispatchTouchEvent(motionEvent);
        }
    }

    public void zzl(String str, String str2) {
        m5675a("error", "what", str, "extra", str2);
    }

    public void zzlv() {
        if (this.f3799d != null) {
            if (!TextUtils.isEmpty(this.f3806k)) {
                this.f3799d.setMimeType(this.f3805j);
                this.f3799d.setVideoPath(this.f3806k);
                return;
            }
            m5675a("no_src", new String[0]);
        }
    }

    public void zzno() {
        if (this.f3799d != null) {
            this.f3799d.zzno();
        }
    }

    public void zznp() {
        if (this.f3799d != null) {
            this.f3799d.zznp();
        }
    }

    public void zzoi() {
        zzkh.zzclc.post(new C1289m(this));
    }

    public void zzoj() {
        if (this.f3799d != null && this.f3804i == 0) {
            m5675a("canplaythrough", "duration", String.valueOf(((float) this.f3799d.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.f3799d.getVideoWidth()), "videoHeight", String.valueOf(this.f3799d.getVideoHeight()));
        }
    }

    public void zzok() {
        m5679e();
    }

    public void zzol() {
        m5675a("ended", new String[0]);
        m5680f();
    }

    public void zzom() {
        m5676b();
        this.f3804i = this.f3803h;
        zzkh.zzclc.post(new C1290n(this));
    }

    public void zzon() {
        if (this.f3799d != null) {
            TextView textView = new TextView(this.f3799d.getContext());
            String valueOf = String.valueOf(this.f3799d.zzni());
            textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.f3797b.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.f3797b.bringChildToFront(textView);
        }
    }
}
