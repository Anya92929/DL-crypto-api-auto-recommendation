package com.google.android.gms.internal;

import com.google.android.gms.internal.zzpm;

/* renamed from: com.google.android.gms.internal.pr */
class C1831pr implements C1833pt {

    /* renamed from: a */
    final /* synthetic */ zzqy f5508a;

    C1831pr(zzqy zzqy) {
        this.f5508a = zzqy;
    }

    /* renamed from: a */
    public void mo7653a(zzpm.zza zza) {
        this.f5508a.f6934a.remove(zza);
        if (!(zza.zzaoj() == null || zzqy.m7540a(this.f5508a) == null)) {
            zzqy.m7540a(this.f5508a).remove(zza.zzaoj().intValue());
        }
        if (this.f5508a.f6937e != null && this.f5508a.f6934a.isEmpty()) {
            this.f5508a.f6937e.mo7645a();
        }
    }
}
