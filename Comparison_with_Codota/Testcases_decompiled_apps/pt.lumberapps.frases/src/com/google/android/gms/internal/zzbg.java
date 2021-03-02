package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;

public class zzbg extends zzbp {

    /* renamed from: i */
    private long f5962i;

    public zzbg(zzax zzax, String str, String str2, zzae.zza zza, long j, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
        this.f5962i = j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        long longValue = ((Long) this.f5986f.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.f5985e) {
            this.f5985e.zzek = Long.valueOf(longValue);
            if (this.f5962i != 0) {
                this.f5985e.zzdi = Long.valueOf(longValue - this.f5962i);
                this.f5985e.zzdn = Long.valueOf(this.f5962i);
            }
        }
    }
}
