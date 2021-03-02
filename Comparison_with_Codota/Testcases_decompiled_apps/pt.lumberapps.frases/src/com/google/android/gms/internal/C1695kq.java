package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.kq */
final class C1695kq implements Callable {

    /* renamed from: a */
    final /* synthetic */ zzio f5237a;

    /* renamed from: b */
    final /* synthetic */ Context f5238b;

    /* renamed from: c */
    final /* synthetic */ AdRequestInfoParcel f5239c;

    /* renamed from: d */
    final /* synthetic */ Bundle f5240d;

    C1695kq(zzio zzio, Context context, AdRequestInfoParcel adRequestInfoParcel, Bundle bundle) {
        this.f5237a = zzio;
        this.f5238b = context;
        this.f5239c = adRequestInfoParcel;
        this.f5240d = bundle;
    }

    /* renamed from: a */
    public Void call() {
        this.f5237a.zzcdw.zza(this.f5238b, this.f5239c.zzcas.packageName, this.f5240d);
        return null;
    }
}
