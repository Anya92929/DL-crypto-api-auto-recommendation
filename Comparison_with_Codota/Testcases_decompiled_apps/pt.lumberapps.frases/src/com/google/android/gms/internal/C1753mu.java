package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.mu */
final class C1753mu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AtomicInteger f5363a;

    /* renamed from: b */
    final /* synthetic */ int f5364b;

    /* renamed from: c */
    final /* synthetic */ zzkv f5365c;

    /* renamed from: d */
    final /* synthetic */ List f5366d;

    C1753mu(AtomicInteger atomicInteger, int i, zzkv zzkv, List list) {
        this.f5363a = atomicInteger;
        this.f5364b = i;
        this.f5365c = zzkv;
        this.f5366d = list;
    }

    public void run() {
        if (this.f5363a.incrementAndGet() >= this.f5364b) {
            try {
                this.f5365c.zzh(zzkx.m7336b(this.f5366d));
            } catch (InterruptedException | ExecutionException e) {
                zzkd.zzd("Unable to convert list of futures to a future of list", e);
            }
        }
    }
}
