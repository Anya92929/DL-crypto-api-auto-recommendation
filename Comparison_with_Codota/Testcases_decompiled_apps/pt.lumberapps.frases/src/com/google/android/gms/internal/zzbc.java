package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;

public class zzbc extends zzbp {

    /* renamed from: i */
    private static volatile Long f5956i = null;

    /* renamed from: j */
    private static final Object f5957j = new Object();

    public zzbc(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        this.f5985e.zzdu = -1L;
        if (f5956i == null) {
            synchronized (f5957j) {
                if (f5956i == null) {
                    f5956i = (Long) this.f5986f.invoke((Object) null, new Object[]{this.f5982b.getContext()});
                }
            }
        }
        synchronized (this.f5985e) {
            this.f5985e.zzdu = f5956i;
        }
    }
}