package com.google.android.gms.internal;

import java.util.Set;

public final class zzamy extends zzamv {

    /* renamed from: a */
    private final zzant f5791a = new zzant();

    public Set entrySet() {
        return this.f5791a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzamy) && ((zzamy) obj).f5791a.equals(this.f5791a));
    }

    public boolean has(String str) {
        return this.f5791a.containsKey(str);
    }

    public int hashCode() {
        return this.f5791a.hashCode();
    }

    public void zza(String str, zzamv zzamv) {
        if (zzamv == null) {
            zzamv = zzamx.bei;
        }
        this.f5791a.put(str, zzamv);
    }

    public zzamv zzto(String str) {
        return (zzamv) this.f5791a.get(str);
    }
}
