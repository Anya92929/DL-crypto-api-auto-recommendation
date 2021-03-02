package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;

public class zzba extends zzbp {

    /* renamed from: i */
    private static volatile String f5952i = null;

    /* renamed from: j */
    private static final Object f5953j = new Object();

    public zzba(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        this.f5985e.zzdp = "E";
        if (f5952i == null) {
            synchronized (f5953j) {
                if (f5952i == null) {
                    f5952i = (String) this.f5986f.invoke((Object) null, new Object[]{this.f5982b.getContext()});
                }
            }
        }
        synchronized (this.f5985e) {
            this.f5985e.zzdp = zzaj.zza(f5952i.getBytes(), true);
        }
    }
}
