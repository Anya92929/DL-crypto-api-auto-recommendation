package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;

/* renamed from: com.google.android.gms.internal.ku */
final class C1699ku implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzio f5249a;

    /* renamed from: b */
    final /* synthetic */ Context f5250b;

    /* renamed from: c */
    final /* synthetic */ zzir f5251c;

    /* renamed from: d */
    final /* synthetic */ AdRequestInfoParcel f5252d;

    C1699ku(zzio zzio, Context context, zzir zzir, AdRequestInfoParcel adRequestInfoParcel) {
        this.f5249a = zzio;
        this.f5250b = context;
        this.f5251c = zzir;
        this.f5252d = adRequestInfoParcel;
    }

    public void run() {
        this.f5249a.zzcdr.zza(this.f5250b, this.f5251c, this.f5252d.zzaow);
    }
}
