package com.appbrain.p032a;

import android.app.Activity;
import android.os.Build;
import com.appbrain.p037f.C1056av;

/* renamed from: com.appbrain.a.ev */
final class C0914ev implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f2400a;

    /* renamed from: b */
    final /* synthetic */ C1056av f2401b;

    /* renamed from: c */
    final /* synthetic */ C0917ey f2402c;

    /* renamed from: d */
    final /* synthetic */ C0920fa f2403d;

    C0914ev(Activity activity, C1056av avVar, C0917ey eyVar, C0920fa faVar) {
        this.f2400a = activity;
        this.f2401b = avVar;
        this.f2402c = eyVar;
        this.f2403d = faVar;
    }

    public final void run() {
        if (Build.VERSION.SDK_INT < 11) {
            C0912et.m3898a(this.f2400a, this.f2401b, this.f2402c.f2406a, this.f2403d);
        } else {
            C0918ez.m3907a(this.f2400a, this.f2401b, this.f2402c.f2406a, this.f2403d);
        }
    }
}
