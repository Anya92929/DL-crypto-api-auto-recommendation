package com.google.android.gms.auth.api.signin.internal;

public class zze {

    /* renamed from: a */
    static int f4220a = 31;

    /* renamed from: b */
    private int f4221b = 1;

    public int zzagc() {
        return this.f4221b;
    }

    public zze zzba(boolean z) {
        this.f4221b = (z ? 1 : 0) + (this.f4221b * f4220a);
        return this;
    }

    public zze zzq(Object obj) {
        this.f4221b = (obj == null ? 0 : obj.hashCode()) + (this.f4221b * f4220a);
        return this;
    }
}
