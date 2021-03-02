package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.bk */
class C1920bk implements Callable {

    /* renamed from: a */
    final /* synthetic */ AppMetadata f7185a;

    /* renamed from: b */
    final /* synthetic */ zzy f7186b;

    C1920bk(zzy zzy, AppMetadata appMetadata) {
        this.f7186b = zzy;
        this.f7185a = appMetadata;
    }

    /* renamed from: a */
    public List call() {
        this.f7186b.f7392a.mo9675m();
        return this.f7186b.f7392a.zzbry().mo9516a(this.f7185a.packageName);
    }
}
