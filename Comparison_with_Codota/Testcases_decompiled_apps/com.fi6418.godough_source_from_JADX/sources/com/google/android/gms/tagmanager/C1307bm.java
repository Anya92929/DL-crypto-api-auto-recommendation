package com.google.android.gms.tagmanager;

import java.util.List;

/* renamed from: com.google.android.gms.tagmanager.bm */
class C1307bm implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f5387a;

    /* renamed from: b */
    final /* synthetic */ long f5388b;

    /* renamed from: c */
    final /* synthetic */ C1306bl f5389c;

    C1307bm(C1306bl blVar, List list, long j) {
        this.f5389c = blVar;
        this.f5387a = list;
        this.f5388b = j;
    }

    public void run() {
        this.f5389c.m5398b(this.f5387a, this.f5388b);
    }
}
