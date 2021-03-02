package com.google.ads;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.C0221g;
import com.google.ads.internal.C0253h;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.util.C0282a;
import com.google.ads.util.C0284b;
import java.util.HashMap;

/* renamed from: com.google.ads.h */
public class C0223h {

    /* renamed from: a */
    final C0253h f429a;

    /* renamed from: b */
    private final C0220f f430b;

    /* renamed from: c */
    private boolean f431c = false;

    /* renamed from: d */
    private boolean f432d = false;

    /* renamed from: e */
    private C0221g.C0222a f433e = null;

    /* renamed from: f */
    private final C0211e f434f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MediationAdapter<?, ?> f435g = null;

    /* renamed from: h */
    private boolean f436h = false;

    /* renamed from: i */
    private boolean f437i = false;

    /* renamed from: j */
    private View f438j = null;

    /* renamed from: k */
    private final String f439k;

    /* renamed from: l */
    private final AdRequest f440l;

    /* renamed from: m */
    private final HashMap<String, String> f441m;

    public C0223h(C0211e eVar, C0253h hVar, C0220f fVar, String str, AdRequest adRequest, HashMap<String, String> hashMap) {
        C0282a.m475b(TextUtils.isEmpty(str));
        this.f434f = eVar;
        this.f429a = hVar;
        this.f430b = fVar;
        this.f439k = str;
        this.f440l = adRequest;
        this.f441m = hashMap;
    }

    /* renamed from: a */
    public C0220f mo3408a() {
        return this.f430b;
    }

    /* renamed from: a */
    public synchronized void mo3409a(Activity activity) {
        C0282a.m476b(this.f436h, "startLoadAdTask has already been called.");
        this.f436h = true;
        C0265m.m411a().f617c.mo3725a().post(new C0226i(this, activity, this.f439k, this.f440l, this.f441m));
    }

    /* renamed from: b */
    public synchronized void mo3413b() {
        C0282a.m473a(this.f436h, "destroy() called but startLoadAdTask has not been called.");
        C0265m.m411a().f617c.mo3725a().post(new Runnable() {
            public void run() {
                if (C0223h.this.mo3423l()) {
                    C0282a.m474b((Object) C0223h.this.f435g);
                    try {
                        C0223h.this.f435g.destroy();
                        C0284b.m480a("Called destroy() for adapter with class: " + C0223h.this.f435g.getClass().getName());
                    } catch (Throwable th) {
                        C0284b.m485b("Error while destroying adapter (" + C0223h.this.mo3419h() + "):", th);
                    }
                }
            }
        });
    }

    /* renamed from: c */
    public synchronized boolean mo3414c() {
        return this.f431c;
    }

    /* renamed from: d */
    public synchronized boolean mo3415d() {
        C0282a.m473a(this.f431c, "isLoadAdTaskSuccessful() called when isLoadAdTaskDone() is false.");
        return this.f432d;
    }

    /* renamed from: e */
    public synchronized C0221g.C0222a mo3416e() {
        C0221g.C0222a aVar;
        if (this.f433e == null) {
            aVar = C0221g.C0222a.TIMEOUT;
        } else {
            aVar = this.f433e;
        }
        return aVar;
    }

    /* renamed from: f */
    public synchronized View mo3417f() {
        C0282a.m473a(this.f431c, "getAdView() called when isLoadAdTaskDone() is false.");
        return this.f438j;
    }

    /* renamed from: g */
    public synchronized void mo3418g() {
        C0282a.m472a(this.f429a.mo3609a());
        try {
            final MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f435g;
            C0265m.m411a().f617c.mo3725a().post(new Runnable() {
                public void run() {
                    try {
                        mediationInterstitialAdapter.showInterstitial();
                    } catch (Throwable th) {
                        C0284b.m485b("Error while telling adapter (" + C0223h.this.mo3419h() + ") ad to show interstitial: ", th);
                    }
                }
            });
        } catch (ClassCastException e) {
            C0284b.m485b("In Ambassador.show(): ambassador.adapter does not implement the MediationInterstitialAdapter interface.", e);
        }
        return;
    }

    /* renamed from: h */
    public synchronized String mo3419h() {
        return this.f435g != null ? this.f435g.getClass().getName() : "\"adapter was not created.\"";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3412a(boolean z, C0221g.C0222a aVar) {
        this.f432d = z;
        this.f431c = true;
        this.f433e = aVar;
        notify();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3411a(MediationAdapter<?, ?> mediationAdapter) {
        this.f435g = mediationAdapter;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public synchronized MediationAdapter<?, ?> mo3420i() {
        return this.f435g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public C0211e mo3421j() {
        return this.f434f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3410a(View view) {
        this.f438j = view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public synchronized void mo3422k() {
        this.f437i = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public synchronized boolean mo3423l() {
        return this.f437i;
    }
}
