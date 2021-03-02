package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;

public class zzbf extends zzbp {

    /* renamed from: i */
    private static volatile Long f5960i = null;

    /* renamed from: j */
    private static final Object f5961j = new Object();

    public zzbf(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        if (f5960i == null) {
            synchronized (f5961j) {
                if (f5960i == null) {
                    f5960i = (Long) this.f5986f.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.f5985e) {
            this.f5985e.zzec = f5960i;
        }
    }
}
