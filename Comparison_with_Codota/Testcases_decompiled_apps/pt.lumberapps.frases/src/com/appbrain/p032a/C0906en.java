package com.appbrain.p032a;

import android.app.Activity;
import com.appbrain.p037f.C1056av;

/* renamed from: com.appbrain.a.en */
final class C0906en implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f2383a;

    /* renamed from: b */
    final /* synthetic */ C1056av f2384b;

    /* renamed from: c */
    final /* synthetic */ boolean f2385c;

    C0906en(Activity activity, C1056av avVar, boolean z) {
        this.f2383a = activity;
        this.f2384b = avVar;
        this.f2385c = z;
    }

    public final void run() {
        if (!this.f2383a.isFinishing()) {
            C0905em.m3882a(this.f2383a, this.f2384b, this.f2385c);
        }
    }
}
