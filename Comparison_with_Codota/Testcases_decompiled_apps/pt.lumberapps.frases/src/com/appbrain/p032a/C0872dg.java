package com.appbrain.p032a;

import com.appbrain.p037f.C1078f;
import com.appbrain.p037f.C1096x;

/* renamed from: com.appbrain.a.dg */
final class C0872dg implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1078f f2325a;

    /* renamed from: b */
    final /* synthetic */ long f2326b = 10000;

    /* renamed from: c */
    final /* synthetic */ C0870de f2327c;

    C0872dg(C0870de deVar, C1078f fVar) {
        this.f2327c = deVar;
        this.f2325a = fVar;
    }

    public final void run() {
        C1096x a = C0870de.m3791a(this.f2327c);
        a.mo4370a(this.f2325a);
        this.f2327c.m3795a(a.mo4028d());
        this.f2327c.m3792a(this.f2326b);
    }
}
