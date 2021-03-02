package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;

public class zzbe extends zzbp {
    public zzbe(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        this.f5985e.zzcw = -1L;
        this.f5985e.zzcx = -1L;
        int[] iArr = (int[]) this.f5986f.invoke((Object) null, new Object[]{this.f5982b.getContext()});
        synchronized (this.f5985e) {
            this.f5985e.zzcw = Long.valueOf((long) iArr[0]);
            this.f5985e.zzcx = Long.valueOf((long) iArr[1]);
        }
    }
}
