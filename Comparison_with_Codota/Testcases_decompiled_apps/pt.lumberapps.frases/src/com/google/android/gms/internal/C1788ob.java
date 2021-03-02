package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;

/* renamed from: com.google.android.gms.internal.ob */
class C1788ob {

    /* renamed from: a */
    public final String f5414a;

    /* renamed from: b */
    public final long f5415b;

    /* renamed from: c */
    public final long f5416c;

    public C1788ob(String str, long j, long j2) {
        this.f5414a = str;
        this.f5415b = j;
        this.f5416c = j2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1788ob)) {
            return false;
        }
        C1788ob obVar = (C1788ob) obj;
        return zzaa.equal(this.f5414a, obVar.f5414a) && zzaa.equal(Long.valueOf(this.f5415b), Long.valueOf(obVar.f5415b)) && zzaa.equal(Long.valueOf(this.f5416c), Long.valueOf(obVar.f5416c));
    }

    public int hashCode() {
        return zzaa.hashCode(this.f5414a, Long.valueOf(this.f5415b), Long.valueOf(this.f5416c));
    }
}
