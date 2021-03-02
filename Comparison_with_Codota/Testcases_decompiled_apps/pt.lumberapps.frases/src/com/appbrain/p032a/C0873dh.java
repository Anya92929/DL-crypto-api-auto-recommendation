package com.appbrain.p032a;

import com.appbrain.p037f.C1061b;
import com.appbrain.p037f.C1076d;
import com.appbrain.p037f.C1096x;

/* renamed from: com.appbrain.a.dh */
final class C0873dh implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2328a;

    /* renamed from: b */
    final /* synthetic */ int f2329b;

    /* renamed from: c */
    final /* synthetic */ long f2330c = 10000;

    /* renamed from: d */
    final /* synthetic */ C0870de f2331d;

    C0873dh(C0870de deVar, String str, int i) {
        this.f2331d = deVar;
        this.f2328a = str;
        this.f2329b = i;
    }

    public final void run() {
        C1076d l = C1061b.m4749l();
        l.mo4329a(this.f2328a);
        l.mo4327a(this.f2329b);
        C1096x a = C0870de.m3791a(this.f2331d);
        a.mo4369a(l);
        this.f2331d.m3795a(a.mo4028d());
        this.f2331d.m3792a(this.f2330c);
    }
}
