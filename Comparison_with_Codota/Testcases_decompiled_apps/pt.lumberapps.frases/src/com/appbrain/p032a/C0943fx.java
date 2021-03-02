package com.appbrain.p032a;

import android.content.Context;
import android.view.View;

/* renamed from: com.appbrain.a.fx */
final class C0943fx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f2482a;

    /* renamed from: b */
    final /* synthetic */ String f2483b;

    /* renamed from: c */
    final /* synthetic */ boolean f2484c;

    /* renamed from: d */
    final /* synthetic */ String f2485d;

    /* renamed from: e */
    final /* synthetic */ String f2486e;

    /* renamed from: f */
    final /* synthetic */ String f2487f;

    /* renamed from: g */
    final /* synthetic */ int f2488g;

    /* renamed from: h */
    final /* synthetic */ C0940fu f2489h;

    C0943fx(C0940fu fuVar, Context context, String str, boolean z, String str2, String str3, String str4, int i) {
        this.f2489h = fuVar;
        this.f2482a = context;
        this.f2483b = str;
        this.f2484c = z;
        this.f2485d = str2;
        this.f2486e = str3;
        this.f2487f = str4;
        this.f2488g = i;
    }

    public final void onClick(View view) {
        C0842cd.m3720a(this.f2482a, this.f2483b, new C0844cf(this.f2484c, this.f2485d, this.f2486e, this.f2487f, this.f2488g));
        if (this.f2484c) {
            C0842cd.m3721a(this.f2482a, this.f2485d, this.f2486e, this.f2487f);
        }
        C0794aj.m3604a(this.f2489h.mo3826g(), C0799ao.AD_CLICKED);
        this.f2489h.mo3727f();
    }
}
