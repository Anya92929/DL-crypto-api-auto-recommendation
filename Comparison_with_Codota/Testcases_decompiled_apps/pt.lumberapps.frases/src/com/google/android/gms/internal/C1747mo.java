package com.google.android.gms.internal;

import com.google.android.gms.internal.zzm;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.mo */
class C1747mo extends zzab {

    /* renamed from: a */
    final /* synthetic */ byte[] f5351a;

    /* renamed from: b */
    final /* synthetic */ Map f5352b;

    /* renamed from: c */
    final /* synthetic */ zzkn f5353c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1747mo(zzkn zzkn, int i, String str, zzm.zzb zzb, zzm.zza zza, byte[] bArr, Map map) {
        super(i, str, zzb, zza);
        this.f5353c = zzkn;
        this.f5351a = bArr;
        this.f5352b = map;
    }

    public Map getHeaders() {
        return this.f5352b == null ? super.getHeaders() : this.f5352b;
    }

    public byte[] zzp() {
        return this.f5351a == null ? super.zzp() : this.f5351a;
    }
}
