package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.ads.internal.client.s */
abstract class C1246s {

    /* renamed from: f */
    final /* synthetic */ zzl f3493f;

    private C1246s(zzl zzl) {
        this.f3493f = zzl;
    }

    /* synthetic */ C1246s(zzl zzl, C1237j jVar) {
        this(zzl);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Object mo5061b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Object mo5062b(zzx zzx);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final Object mo5079c() {
        zzx a = this.f3493f.m5610b();
        if (a == null) {
            zzb.zzcx("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return mo5062b(a);
        } catch (RemoteException e) {
            zzb.zzd("Cannot invoke local loader using ClientApi class", e);
            return null;
        }
    }
}
