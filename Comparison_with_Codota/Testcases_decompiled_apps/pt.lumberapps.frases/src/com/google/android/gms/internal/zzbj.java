package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;

public class zzbj extends zzbp {

    /* renamed from: i */
    private static volatile Long f5965i = null;

    /* renamed from: j */
    private static final Object f5966j = new Object();

    public zzbj(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        if (f5965i == null) {
            synchronized (f5966j) {
                if (f5965i == null) {
                    f5965i = (Long) this.f5986f.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.f5985e) {
            this.f5985e.zzdm = f5965i;
        }
    }
}
