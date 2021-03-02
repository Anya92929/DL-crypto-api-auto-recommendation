package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.ot */
class C1806ot extends C1810ox {

    /* renamed from: a */
    final /* synthetic */ zzpw f5454a;

    /* renamed from: c */
    private final ArrayList f5455c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1806ot(zzpw zzpw, ArrayList arrayList) {
        super(zzpw, (C1801oo) null);
        this.f5454a = zzpw;
        this.f5455c = arrayList;
    }

    /* renamed from: a */
    public void mo7627a() {
        this.f5454a.f6815a.f6867g.f6840d = this.f5454a.m7460g();
        Iterator it = this.f5455c.iterator();
        while (it.hasNext()) {
            ((Api.zze) it.next()).zza(this.f5454a.f6829o, this.f5454a.f6815a.f6867g.f6840d);
        }
    }
}
