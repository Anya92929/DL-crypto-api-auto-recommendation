package com.appbrain.p032a;

import android.content.Context;
import android.view.View;
import cmn.C0739bg;
import cmn.C0740bh;

/* renamed from: com.appbrain.a.cy */
final class C0863cy implements C0955gi {

    /* renamed from: a */
    final /* synthetic */ String f2289a;

    /* renamed from: b */
    final /* synthetic */ C0962i f2290b;

    /* renamed from: c */
    final /* synthetic */ C0970q f2291c;

    /* renamed from: d */
    final /* synthetic */ C0785aa f2292d;

    /* renamed from: e */
    final /* synthetic */ Context f2293e;

    /* renamed from: f */
    final /* synthetic */ C0861cw f2294f;

    C0863cy(C0861cw cwVar, String str, C0962i iVar, C0970q qVar, C0785aa aaVar, Context context) {
        this.f2294f = cwVar;
        this.f2289a = str;
        this.f2290b = iVar;
        this.f2291c = qVar;
        this.f2292d = aaVar;
        this.f2293e = context;
    }

    /* renamed from: a */
    public final View mo3715a(int i) {
        String a = C0739bg.m3252a(this.f2289a, i, C0740bh.HEIGHT);
        if (a.startsWith("/")) {
            a = C0932fm.m3968a().mo3841a("adserver", C0793ai.f2083c) + a;
        }
        return this.f2292d.mo3631a(this.f2293e, new C0979z(this.f2290b, a, this.f2291c, i));
    }

    /* renamed from: a */
    public final String mo3716a() {
        return this.f2290b.f2553e;
    }
}
