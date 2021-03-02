package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzin
public class zzfc implements Iterable {

    /* renamed from: a */
    private final List f6171a = new LinkedList();

    /* renamed from: a */
    private zzfb m7020a(zzlh zzlh) {
        Iterator it = zzu.zzgj().iterator();
        while (it.hasNext()) {
            zzfb zzfb = (zzfb) it.next();
            if (zzfb.f6168a == zzlh) {
                return zzfb;
            }
        }
        return null;
    }

    public Iterator iterator() {
        return this.f6171a.iterator();
    }

    public void zza(zzfb zzfb) {
        this.f6171a.add(zzfb);
    }

    public void zzb(zzfb zzfb) {
        this.f6171a.remove(zzfb);
    }

    public boolean zzd(zzlh zzlh) {
        zzfb a = m7020a(zzlh);
        if (a == null) {
            return false;
        }
        a.f6169b.abort();
        return true;
    }

    public boolean zze(zzlh zzlh) {
        return m7020a(zzlh) != null;
    }

    public int zzlk() {
        return this.f6171a.size();
    }
}
