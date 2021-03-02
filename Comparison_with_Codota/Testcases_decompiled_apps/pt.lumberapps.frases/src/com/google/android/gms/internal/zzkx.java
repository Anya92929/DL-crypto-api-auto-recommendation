package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@zzin
public class zzkx {

    public interface zza {
        Object apply(Object obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List m7336b(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = ((zzky) it.next()).get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static zzky zza(zzky zzky, zza zza2) {
        zzkv zzkv = new zzkv();
        zzky.zzc(new C1752mt(zzkv, zza2, zzky));
        return zzkv;
    }

    public static zzky zzn(List list) {
        zzkv zzkv = new zzkv();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzky) it.next()).zzc(new C1753mu(atomicInteger, size, zzkv, list));
        }
        return zzkv;
    }
}
