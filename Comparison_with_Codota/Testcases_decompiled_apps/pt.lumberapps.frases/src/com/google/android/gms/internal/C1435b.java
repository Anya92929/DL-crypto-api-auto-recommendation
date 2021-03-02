package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.b */
class C1435b extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ C1408a f4866a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1435b(C1408a aVar, Handler handler) {
        super(handler);
        this.f4866a = aVar;
    }

    public void onChange(boolean z) {
        synchronized (zzaeo.class) {
            zzaeo.f5550a.clear();
            Object unused = zzaeo.f5552c = new Object();
            if (!zzaeo.f5551b.isEmpty()) {
                zzaeo.zzb(this.f4866a.f4816a, (String[]) zzaeo.f5551b.toArray(new String[zzaeo.f5551b.size()]));
            }
        }
    }
}
