package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzq;
import java.util.Collections;

/* renamed from: com.google.android.gms.internal.pk */
class C1824pk implements zzd.zzf {

    /* renamed from: a */
    final /* synthetic */ zzqc f5494a;

    /* renamed from: b */
    private final Api.zze f5495b;

    /* renamed from: c */
    private final zzpj f5496c;

    public C1824pk(zzqc zzqc, Api.zze zze, zzpj zzpj) {
        this.f5494a = zzqc;
        this.f5495b = zze;
        this.f5496c = zzpj;
    }

    public void zzh(ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            this.f5495b.zza((zzq) null, Collections.emptySet());
        } else {
            ((C1822pi) this.f5494a.f6887k.get(this.f5496c)).onConnectionFailed(connectionResult);
        }
    }
}
