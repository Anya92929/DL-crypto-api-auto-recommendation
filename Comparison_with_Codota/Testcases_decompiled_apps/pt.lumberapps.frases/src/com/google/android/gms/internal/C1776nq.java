package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.gms.internal.nq */
class C1776nq implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ zzpb f5400a;

    C1776nq(zzpb zzpb) {
        this.f5400a = zzpb;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(new C1777nr(this, runnable), "ClearcutLoggerApiImpl");
    }
}
