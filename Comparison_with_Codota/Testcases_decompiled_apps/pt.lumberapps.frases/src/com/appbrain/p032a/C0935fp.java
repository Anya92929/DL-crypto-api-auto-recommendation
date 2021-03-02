package com.appbrain.p032a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import cmn.C0725at;
import com.appbrain.AppBrainActivity;
import com.appbrain.C1027e;

/* renamed from: com.appbrain.a.fp */
final class C0935fp implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f2450a;

    /* renamed from: b */
    final /* synthetic */ C1027e f2451b;

    /* renamed from: c */
    final /* synthetic */ Bundle f2452c;

    C0935fp(Context context, C1027e eVar, Bundle bundle) {
        this.f2450a = context;
        this.f2451b = eVar;
        this.f2452c = bundle;
    }

    public final void run() {
        Activity a = C0725at.m3226a(this.f2450a);
        if (a == null || this.f2451b == C1027e.FULLSCREEN || Build.VERSION.SDK_INT < 14 || C0725at.m3232b(a) || !C0924fe.m3919a(a, this.f2452c)) {
            AppBrainActivity.m3569a(this.f2450a, this.f2452c);
        }
    }
}
