package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.nio.ByteBuffer;

public class zzbb extends zzbp {

    /* renamed from: i */
    private static volatile String f5954i = null;

    /* renamed from: j */
    private static final Object f5955j = new Object();

    public zzbb(zzax zzax, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzax, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8119a() {
        this.f5985e.zzdo = "E";
        if (f5954i == null) {
            synchronized (f5955j) {
                if (f5954i == null) {
                    f5954i = zzaj.zza(((ByteBuffer) this.f5986f.invoke((Object) null, new Object[]{this.f5982b.getContext()})).array(), true);
                }
            }
        }
        synchronized (this.f5985e) {
            this.f5985e.zzdo = f5954i;
        }
    }
}
