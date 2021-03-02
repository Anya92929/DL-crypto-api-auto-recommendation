package com.appbrain.p032a;

import android.app.Activity;
import android.os.MessageQueue;
import com.appbrain.p037f.C1056av;

/* renamed from: com.appbrain.a.eu */
final class C0913eu implements MessageQueue.IdleHandler {

    /* renamed from: a */
    final /* synthetic */ Activity f2397a;

    /* renamed from: b */
    final /* synthetic */ C1056av f2398b;

    /* renamed from: c */
    final /* synthetic */ C0917ey f2399c;

    C0913eu(Activity activity, C1056av avVar, C0917ey eyVar) {
        this.f2397a = activity;
        this.f2398b = avVar;
        this.f2399c = eyVar;
    }

    public final boolean queueIdle() {
        C0912et.m3901b(this.f2397a, this.f2398b, this.f2399c);
        return false;
    }
}
