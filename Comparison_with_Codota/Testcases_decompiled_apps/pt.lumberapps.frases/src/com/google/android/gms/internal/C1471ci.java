package com.google.android.gms.internal;

import java.sql.Timestamp;
import java.util.Date;

/* renamed from: com.google.android.gms.internal.ci */
class C1471ci extends zzanh {

    /* renamed from: a */
    final /* synthetic */ zzanh f4915a;

    /* renamed from: b */
    final /* synthetic */ C1470ch f4916b;

    C1471ci(C1470ch chVar, zzanh zzanh) {
        this.f4916b = chVar;
        this.f4915a = zzanh;
    }

    /* renamed from: a */
    public Timestamp zzb(zzaom zzaom) {
        Date date = (Date) this.f4915a.zzb(zzaom);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Timestamp timestamp) {
        this.f4915a.zza(zzaoo, timestamp);
    }
}
