package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzaa;

public final class zzpj {

    /* renamed from: a */
    private final Api f6777a;

    /* renamed from: b */
    private final Api.ApiOptions f6778b;

    public zzpj(Api api, Api.ApiOptions apiOptions) {
        this.f6777a = api;
        this.f6778b = apiOptions;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzpj)) {
            return false;
        }
        zzpj zzpj = (zzpj) obj;
        return zzaa.equal(this.f6777a, zzpj.f6777a) && zzaa.equal(this.f6778b, zzpj.f6778b);
    }

    public int hashCode() {
        return zzaa.hashCode(this.f6777a, this.f6778b);
    }

    public Api.zzc zzans() {
        return this.f6777a.zzans();
    }

    public String zzaon() {
        return this.f6777a.getName();
    }
}
