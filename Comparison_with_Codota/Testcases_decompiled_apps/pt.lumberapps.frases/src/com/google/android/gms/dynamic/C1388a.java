package com.google.android.gms.dynamic;

import android.os.Bundle;
import java.util.Iterator;

/* renamed from: com.google.android.gms.dynamic.a */
class C1388a implements zzf {

    /* renamed from: a */
    final /* synthetic */ zza f4759a;

    C1388a(zza zza) {
        this.f4759a = zza;
    }

    public void zza(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate unused = this.f4759a.f4777a = lifecycleDelegate;
        Iterator it = this.f4759a.f4779c.iterator();
        while (it.hasNext()) {
            ((C1395h) it.next()).mo6949a(this.f4759a.f4777a);
        }
        this.f4759a.f4779c.clear();
        Bundle unused2 = this.f4759a.f4778b = null;
    }
}
