package com.appbrain.p032a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import cmn.C0708ac;
import cmn.C0709ad;
import cmn.C0725at;
import cmn.C0752n;
import com.appbrain.AppBrainBanner;
import com.appbrain.C0783a;
import com.appbrain.C1135w;
import com.appbrain.C1138z;
import com.appbrain.p037f.C1054at;

/* renamed from: com.appbrain.a.gd */
public final class C0950gd {

    /* renamed from: a */
    private final Handler f2507a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private final AppBrainBanner f2508b;

    /* renamed from: c */
    private final C0845cg f2509c;

    /* renamed from: d */
    private final C0861cw f2510d;

    /* renamed from: e */
    private final C0867db f2511e;

    /* renamed from: f */
    private boolean f2512f;

    /* renamed from: g */
    private boolean f2513g;

    /* renamed from: h */
    private boolean f2514h;

    /* renamed from: i */
    private boolean f2515i;

    /* renamed from: j */
    private String f2516j;

    /* renamed from: k */
    private C1135w f2517k = C1135w.RESPONSIVE;

    /* renamed from: l */
    private C0955gi f2518l;

    /* renamed from: m */
    private int f2519m;

    /* renamed from: n */
    private C0783a f2520n;

    /* renamed from: o */
    private final C0708ac f2521o = new C0953gg(this);

    public C0950gd(AppBrainBanner appBrainBanner, C0785aa aaVar) {
        this.f2508b = appBrainBanner;
        if (appBrainBanner.isInEditMode()) {
            C0709ad.m3187a(appBrainBanner.getContext());
        } else {
            C0926fg.m3925a().mo3817a(appBrainBanner.getContext(), true, false);
        }
        this.f2509c = new C0845cg();
        this.f2510d = new C0861cw(aaVar);
        this.f2511e = new C0867db();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4035a(C0955gi giVar) {
        this.f2518l = giVar;
        m4036c();
        m4037d();
    }

    /* renamed from: c */
    private void m4036c() {
        this.f2508b.removeAllViews();
        if (this.f2519m != 0 && this.f2518l != null) {
            this.f2508b.addView(this.f2518l.mo3715a(this.f2519m), -1, this.f2519m);
        }
    }

    /* renamed from: d */
    private void m4037d() {
        m4038e();
        try {
            if (this.f2508b.getBannerListener() != null) {
                this.f2508b.getBannerListener().mo4444a(this.f2518l != null);
            }
        } finally {
            this.f2512f = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m4038e() {
        if (!this.f2513g && this.f2518l != null && this.f2519m != 0 && this.f2508b.hasWindowFocus() && this.f2508b.getVisibility() == 0 && !this.f2508b.isInEditMode()) {
            this.f2513g = true;
            C0802ar.m3607a(this.f2508b.getContext(), this.f2518l.mo3716a());
        }
    }

    /* renamed from: f */
    private int m4039f() {
        int i = 90;
        int i2 = 50;
        switch (C0954gh.f2526a[this.f2517k.ordinal()]) {
            case 2:
                i2 = 90;
                break;
            case 3:
                if (!C0725at.m3233b(this.f2508b.getContext())) {
                    i = 50;
                }
                return C0709ad.m3188b((float) i);
        }
        return C0709ad.m3188b((float) i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m4040g(int i) {
        if (this.f2519m != i) {
            this.f2519m = i;
            m4036c();
        }
    }

    /* renamed from: a */
    public final void mo3871a() {
        boolean z;
        Integer num = null;
        if (!this.f2512f) {
            this.f2512f = true;
            if (this.f2514h) {
                m4037d();
                return;
            }
            this.f2514h = true;
            if (this.f2508b.isInEditMode() || this.f2510d.mo3740a() || C0926fg.m3925a().mo3823g()) {
                z = true;
            } else {
                String a = C0932fm.m3968a().mo3841a("adserver", C0793ai.f2083c);
                if (a.startsWith("http://10.0.2.2") || a.startsWith("http://192.168.")) {
                    z = true;
                } else {
                    C0752n b = C0752n.m3278b();
                    if (b.mo3436j() != -1 && b.mo3438l() >= 5000 && Build.VERSION.SDK_INT >= 10) {
                        if (Math.random() < Math.max(0.0d, Math.min(1.0d, this.f2515i ? C0932fm.m3968a().mo3839a("bmedsample", 1.0d) : C0932fm.m3968a().mo3839a("bsample", 1.0d)))) {
                            z = true;
                        }
                    }
                    z = false;
                }
            }
            if (!z) {
                m4035a((C0955gi) null);
                return;
            }
            C0789ae aeVar = this.f2508b.isInEditMode() ? new C0789ae(C0790af.f2069a, this.f2516j) : this.f2510d.mo3740a() ? new C0789ae(C0790af.f2070b, this.f2516j) : C0787ac.m3593a().mo3633a(this.f2516j);
            String str = aeVar.f2068b;
            if (str != null) {
                str = str.substring(0, Math.min(10, str.length()));
            }
            Context context = this.f2508b.getContext();
            if (aeVar.f2067a != C0790af.f2070b || !this.f2510d.mo3740a()) {
                context = C0934fo.m3992a(context);
            }
            if (aeVar.f2067a == C0790af.f2070b) {
                C0861cw cwVar = this.f2510d;
                C1138z bannerListener = this.f2508b.getBannerListener();
                C0708ac acVar = this.f2521o;
                C0783a aVar = this.f2520n;
                if (aVar != null) {
                    num = Integer.valueOf(aVar.mo3616a());
                }
                C0956gj.m4057a().mo3885a(context, C1054at.BANNER, num, str, new C0862cx(cwVar, acVar, context, bannerListener), true);
            } else if (aeVar.f2067a == C0790af.f2071c) {
                C0867db dbVar = this.f2511e;
                C1138z bannerListener2 = this.f2508b.getBannerListener();
                C0708ac acVar2 = this.f2521o;
                C0783a aVar2 = this.f2520n;
                if (aVar2 != null) {
                    num = Integer.valueOf(aVar2.mo3616a());
                }
                C0956gj.m4057a().mo3885a(context, C1054at.BANNER, num, str, new C0868dc(dbVar, acVar2, context, bannerListener2), false);
            } else {
                m4035a(this.f2509c.mo3708a(context, str, this.f2508b.getBannerListener(), this.f2520n));
            }
        }
    }

    /* renamed from: a */
    public final void mo3872a(int i) {
        this.f2509c.mo3709a(i);
    }

    /* renamed from: a */
    public final void mo3873a(AttributeSet attributeSet) {
        String attributeValue;
        this.f2509c.mo3710a(attributeSet, this.f2508b.isInEditMode());
        this.f2510d.mo3739a(attributeSet);
        if (attributeSet != null && (attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.appbrain", "adid")) != null) {
            mo3874a(C0783a.m3582b(attributeValue));
        }
    }

    /* renamed from: a */
    public final void mo3874a(C0783a aVar) {
        if (aVar == null || aVar.mo3618c()) {
            this.f2520n = aVar;
            return;
        }
        Log.println(6, "AppBrain", "Ad id '" + aVar + "' is not a banner id. Using no ad id instead.");
        this.f2520n = null;
    }

    /* renamed from: a */
    public final void mo3875a(C1135w wVar) {
        this.f2517k = wVar;
    }

    /* renamed from: a */
    public final void mo3876a(boolean z, String str) {
        this.f2515i = z;
        this.f2516j = str;
    }

    /* renamed from: b */
    public final void mo3877b() {
        if (this.f2514h) {
            m4038e();
        } else if (this.f2508b.hasWindowFocus() && this.f2508b.getVisibility() == 0) {
            mo3871a();
        }
    }

    /* renamed from: b */
    public final void mo3878b(int i) {
        this.f2509c.mo3711b(i);
    }

    /* renamed from: c */
    public final void mo3879c(int i) {
        this.f2509c.mo3712c(i);
    }

    /* renamed from: d */
    public final void mo3880d(int i) {
        this.f2509c.mo3713d(i);
    }

    /* renamed from: e */
    public final void mo3881e(int i) {
        this.f2510d.mo3738a(i);
    }

    /* renamed from: f */
    public final void mo3882f(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (this.f2510d.mo3740a()) {
            size = -2;
        } else if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(size, m4039f()) : m4039f();
        }
        if (this.f2508b.isInEditMode()) {
            m4040g(size);
            return;
        }
        this.f2507a.removeCallbacksAndMessages((Object) null);
        this.f2507a.post(new C0951ge(this, size));
    }
}
