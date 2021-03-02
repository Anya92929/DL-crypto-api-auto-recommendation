package com.appbrain.p032a;

import android.content.Context;
import android.view.View;
import com.appbrain.C1138z;

/* renamed from: com.appbrain.a.cz */
final class C0864cz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f2295a;

    /* renamed from: b */
    final /* synthetic */ String f2296b;

    /* renamed from: c */
    final /* synthetic */ boolean f2297c;

    /* renamed from: d */
    final /* synthetic */ String f2298d;

    /* renamed from: e */
    final /* synthetic */ String f2299e;

    /* renamed from: f */
    final /* synthetic */ String f2300f;

    /* renamed from: g */
    final /* synthetic */ int f2301g;

    /* renamed from: h */
    final /* synthetic */ C1138z f2302h;

    C0864cz(Context context, String str, boolean z, String str2, String str3, String str4, int i, C1138z zVar) {
        this.f2295a = context;
        this.f2296b = str;
        this.f2297c = z;
        this.f2298d = str2;
        this.f2299e = str3;
        this.f2300f = str4;
        this.f2301g = i;
        this.f2302h = zVar;
    }

    public final void onClick(View view) {
        C0842cd.m3720a(this.f2295a, this.f2296b, new C0844cf(this.f2297c, this.f2298d, this.f2299e, this.f2300f, this.f2301g));
        if (this.f2297c) {
            C0842cd.m3721a(this.f2295a, this.f2298d, this.f2299e, this.f2300f);
        }
        if (this.f2302h != null) {
            try {
                this.f2302h.onClick();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
