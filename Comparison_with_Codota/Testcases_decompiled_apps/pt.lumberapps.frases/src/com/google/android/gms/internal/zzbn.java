package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;

public class zzbn extends zzbp {

    /* renamed from: i */
    private static volatile Long f5971i = null;

    /* renamed from: j */
    private static final Object f5972j = new Object();

    public zzbn(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        if (f5971i == null) {
            synchronized (f5972j) {
                if (f5971i == null) {
                    f5971i = (Long) this.f5986f.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.f5985e) {
            this.f5985e.zzds = f5971i;
        }
    }
}
