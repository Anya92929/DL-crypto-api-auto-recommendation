package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

@zzin
public class zzfq {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public zzfp m7051a(Context context, VersionInfoParcel versionInfoParcel, C1609hl hlVar, zzas zzas) {
        zzfr zzfr = new zzfr(context, versionInfoParcel, zzas);
        hlVar.f5094a = zzfr;
        zzfr.zza(new C1608hk(this, hlVar));
        return zzfr;
    }

    public Future zza(Context context, VersionInfoParcel versionInfoParcel, String str, zzas zzas) {
        C1609hl hlVar = new C1609hl((C1607hj) null);
        zzkh.zzclc.post(new C1607hj(this, context, versionInfoParcel, hlVar, zzas, str));
        return hlVar;
    }
}
