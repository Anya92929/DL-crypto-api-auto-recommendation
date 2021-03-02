package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@zzin
public class zzcz {

    /* renamed from: a */
    private final Collection f6090a = new ArrayList();

    /* renamed from: b */
    private final Collection f6091b = new ArrayList();

    /* renamed from: c */
    private final Collection f6092c = new ArrayList();

    public void zza(zzcy zzcy) {
        this.f6090a.add(zzcy);
    }

    public void zzb(zzcy zzcy) {
        this.f6091b.add(zzcy);
    }

    public void zzc(zzcy zzcy) {
        this.f6092c.add(zzcy);
    }

    public List zzjx() {
        ArrayList arrayList = new ArrayList();
        for (zzcy zzcy : this.f6091b) {
            String str = (String) zzcy.get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public List zzjy() {
        List zzjx = zzjx();
        for (zzcy zzcy : this.f6092c) {
            String str = (String) zzcy.get();
            if (str != null) {
                zzjx.add(str);
            }
        }
        return zzjx;
    }
}
