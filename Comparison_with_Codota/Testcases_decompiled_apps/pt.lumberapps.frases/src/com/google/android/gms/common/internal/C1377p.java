package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.p */
class C1377p extends zzf {

    /* renamed from: a */
    List f4495a;

    C1377p(List list) {
        this.f4495a = list;
    }

    public zzf zza(zzf zzf) {
        ArrayList arrayList = new ArrayList(this.f4495a);
        arrayList.add((zzf) zzab.zzy(zzf));
        return new C1377p(arrayList);
    }

    public boolean zzd(char c) {
        for (zzf zzd : this.f4495a) {
            if (zzd.zzd(c)) {
                return true;
            }
        }
        return false;
    }
}
