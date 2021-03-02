package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;

public class zzbk extends zzbp {

    /* renamed from: i */
    private long f5967i = -1;

    public zzbk(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        this.f5985e.zzdd = -1L;
        if (this.f5967i == -1) {
            this.f5967i = (long) ((Integer) this.f5986f.invoke((Object) null, new Object[]{this.f5982b.getContext()})).intValue();
        }
        synchronized (this.f5985e) {
            this.f5985e.zzdd = Long.valueOf(this.f5967i);
        }
    }
}
