package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;

public class zzbl extends zzbp {

    /* renamed from: i */
    private static volatile String f5968i = null;

    /* renamed from: j */
    private static final Object f5969j = new Object();

    public zzbl(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        this.f5985e.zzct = "E";
        if (f5968i == null) {
            synchronized (f5969j) {
                if (f5968i == null) {
                    f5968i = (String) this.f5986f.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.f5985e) {
            this.f5985e.zzct = f5968i;
        }
    }
}
