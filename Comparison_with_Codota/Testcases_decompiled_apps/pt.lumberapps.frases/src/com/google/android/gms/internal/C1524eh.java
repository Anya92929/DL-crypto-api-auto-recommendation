package com.google.android.gms.internal;

import com.google.android.gms.internal.zzct;
import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.eh */
class C1524eh implements Comparator {

    /* renamed from: a */
    final /* synthetic */ zzcq f4968a;

    C1524eh(zzcq zzcq) {
        this.f4968a = zzcq;
    }

    /* renamed from: a */
    public int compare(zzct.zza zza, zzct.zza zza2) {
        int i = zza.f6084c - zza2.f6084c;
        return i != 0 ? i : (int) (zza.f6082a - zza2.f6082a);
    }
}
