package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@zzin
public class zzdj {

    /* renamed from: a */
    private final Map f6117a = new HashMap();

    /* renamed from: b */
    private final zzdk f6118b;

    public zzdj(zzdk zzdk) {
        this.f6118b = zzdk;
    }

    public void zza(String str, zzdi zzdi) {
        this.f6117a.put(str, zzdi);
    }

    public void zza(String str, String str2, long j) {
        zzdg.zza(this.f6118b, (zzdi) this.f6117a.get(str2), j, str);
        this.f6117a.put(str, zzdg.zza(this.f6118b, j));
    }

    public zzdk zzkf() {
        return this.f6118b;
    }
}
