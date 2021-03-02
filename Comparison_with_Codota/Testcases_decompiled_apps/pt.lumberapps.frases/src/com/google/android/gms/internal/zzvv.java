package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;

public final class zzvv implements Api.ApiOptions.Optional {
    public static final zzvv atR = new zza().zzbzt();

    /* renamed from: a */
    private final boolean f7033a;

    /* renamed from: b */
    private final boolean f7034b;

    /* renamed from: c */
    private final String f7035c;

    /* renamed from: d */
    private final boolean f7036d;

    /* renamed from: e */
    private final String f7037e;

    /* renamed from: f */
    private final boolean f7038f;

    /* renamed from: g */
    private final Long f7039g;

    /* renamed from: h */
    private final Long f7040h;

    public final class zza {
        public zzvv zzbzt() {
            return new zzvv(false, false, (String) null, false, (String) null, false, (Long) null, (Long) null);
        }
    }

    private zzvv(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
        this.f7033a = z;
        this.f7034b = z2;
        this.f7035c = str;
        this.f7036d = z3;
        this.f7038f = z4;
        this.f7037e = str2;
        this.f7039g = l;
        this.f7040h = l2;
    }

    public boolean zzafr() {
        return this.f7034b;
    }

    public boolean zzaft() {
        return this.f7036d;
    }

    public String zzafu() {
        return this.f7035c;
    }

    public String zzafv() {
        return this.f7037e;
    }

    public boolean zzbzp() {
        return this.f7033a;
    }

    public boolean zzbzq() {
        return this.f7038f;
    }

    public Long zzbzr() {
        return this.f7039g;
    }

    public Long zzbzs() {
        return this.f7040h;
    }
}
