package com.appbrain.p032a;

import android.content.Context;
import android.view.View;

/* renamed from: com.appbrain.a.ci */
final class C0847ci implements C0955gi {

    /* renamed from: a */
    final /* synthetic */ String f2241a;

    /* renamed from: b */
    final /* synthetic */ String f2242b;

    /* renamed from: c */
    final /* synthetic */ C0970q f2243c;

    /* renamed from: d */
    final /* synthetic */ View.OnClickListener f2244d;

    /* renamed from: e */
    final /* synthetic */ C0974u f2245e;

    /* renamed from: f */
    final /* synthetic */ Context f2246f;

    /* renamed from: g */
    final /* synthetic */ String f2247g;

    /* renamed from: h */
    final /* synthetic */ C0845cg f2248h;

    C0847ci(C0845cg cgVar, String str, String str2, C0970q qVar, View.OnClickListener onClickListener, C0974u uVar, Context context, String str3) {
        this.f2248h = cgVar;
        this.f2241a = str;
        this.f2242b = str2;
        this.f2243c = qVar;
        this.f2244d = onClickListener;
        this.f2245e = uVar;
        this.f2246f = context;
        this.f2247g = str3;
    }

    /* renamed from: a */
    public final View mo3715a(int i) {
        return this.f2245e.mo3890a(this.f2246f, new C0973t(this.f2241a, this.f2242b, this.f2243c, i, this.f2244d));
    }

    /* renamed from: a */
    public final String mo3716a() {
        return this.f2247g;
    }
}
