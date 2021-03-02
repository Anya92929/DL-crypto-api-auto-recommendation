package com.google.android.gms.auth.api.signin.internal;

public class zze {

    /* renamed from: a */
    static int f2524a = 31;

    /* renamed from: b */
    private int f2525b = 1;

    public zze zzP(boolean z) {
        this.f2525b = (z ? 1 : 0) + (this.f2525b * f2524a);
        return this;
    }

    public int zzne() {
        return this.f2525b;
    }

    public zze zzp(Object obj) {
        this.f2525b = (obj == null ? 0 : obj.hashCode()) + (this.f2525b * f2524a);
        return this;
    }
}
