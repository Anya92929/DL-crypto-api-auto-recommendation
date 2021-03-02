package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;

public class zzbd extends zzbp {

    /* renamed from: i */
    private static volatile String f5958i = null;

    /* renamed from: j */
    private static final Object f5959j = new Object();

    public zzbd(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        this.f5985e.zzdt = "E";
        if (f5958i == null) {
            synchronized (f5959j) {
                if (f5958i == null) {
                    f5958i = (String) this.f5986f.invoke((Object) null, new Object[]{this.f5982b.getContext()});
                }
            }
        }
        synchronized (this.f5985e) {
            this.f5985e.zzdt = f5958i;
        }
    }
}
