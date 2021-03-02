package com.appbrain.p032a;

import android.content.Context;
import android.view.View;
import com.appbrain.C0783a;
import com.appbrain.C1138z;
import com.appbrain.p037f.C1054at;

/* renamed from: com.appbrain.a.ch */
final class C0846ch implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2235a;

    /* renamed from: b */
    final /* synthetic */ int f2236b;

    /* renamed from: c */
    final /* synthetic */ C0783a f2237c;

    /* renamed from: d */
    final /* synthetic */ Context f2238d;

    /* renamed from: e */
    final /* synthetic */ C1138z f2239e;

    /* renamed from: f */
    final /* synthetic */ C0845cg f2240f;

    C0846ch(C0845cg cgVar, String str, int i, C0783a aVar, Context context, C1138z zVar) {
        this.f2240f = cgVar;
        this.f2235a = str;
        this.f2236b = i;
        this.f2237c = aVar;
        this.f2238d = context;
        this.f2239e = zVar;
    }

    public final void onClick(View view) {
        C0936fq fqVar = new C0936fq(C1054at.BANNER);
        fqVar.f2455c = this.f2235a;
        fqVar.f2456d = Integer.valueOf(this.f2236b);
        fqVar.f2457e = true;
        if (this.f2237c != null) {
            fqVar.f2460h = Integer.valueOf(this.f2237c.mo3616a());
        }
        C0934fo.m3998a(this.f2238d, fqVar);
        if (this.f2239e != null) {
            try {
                this.f2239e.onClick();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
