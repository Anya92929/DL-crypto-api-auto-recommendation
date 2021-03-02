package com.appbrain.p032a;

import android.content.Context;
import com.appbrain.p037f.C1056av;

/* renamed from: com.appbrain.a.ei */
final class C0901ei implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1056av f2374a;

    /* renamed from: b */
    final /* synthetic */ Context f2375b;

    C0901ei(C1056av avVar, Context context) {
        this.f2374a = avVar;
        this.f2375b = context;
    }

    public final void run() {
        C0902ej.m3874a(this.f2374a, true);
        C0911es.m3894a(this.f2375b, this.f2374a.mo4246p(), this.f2374a.mo4248r());
    }
}
