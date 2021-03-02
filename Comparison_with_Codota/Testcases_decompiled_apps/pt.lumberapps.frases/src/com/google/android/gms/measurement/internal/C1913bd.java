package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzuh;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.bd */
class C1913bd implements C1890ah {

    /* renamed from: a */
    zzuh.zze f7162a;

    /* renamed from: b */
    List f7163b;

    /* renamed from: c */
    List f7164c;

    /* renamed from: d */
    long f7165d;

    /* renamed from: e */
    final /* synthetic */ zzx f7166e;

    private C1913bd(zzx zzx) {
        this.f7166e = zzx;
    }

    /* synthetic */ C1913bd(zzx zzx, C1910ba baVar) {
        this(zzx);
    }

    /* renamed from: a */
    private long m7703a(zzuh.zzb zzb) {
        return ((zzb.ano.longValue() / 1000) / 60) / 60;
    }

    /* renamed from: a */
    public void mo9227a(zzuh.zze zze) {
        zzab.zzy(zze);
        this.f7162a = zze;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9308a() {
        return this.f7164c == null || this.f7164c.isEmpty();
    }

    /* renamed from: a */
    public boolean mo9228a(long j, zzuh.zzb zzb) {
        zzab.zzy(zzb);
        if (this.f7164c == null) {
            this.f7164c = new ArrayList();
        }
        if (this.f7163b == null) {
            this.f7163b = new ArrayList();
        }
        if (this.f7164c.size() > 0 && m7703a((zzuh.zzb) this.f7164c.get(0)) != m7703a(zzb)) {
            return false;
        }
        long aM = this.f7165d + ((long) zzb.mo8049aM());
        if (aM >= ((long) this.f7166e.zzbsf().zzbri())) {
            return false;
        }
        this.f7165d = aM;
        this.f7164c.add(zzb);
        this.f7163b.add(Long.valueOf(j));
        return this.f7164c.size() < this.f7166e.zzbsf().zzbrj();
    }
}
