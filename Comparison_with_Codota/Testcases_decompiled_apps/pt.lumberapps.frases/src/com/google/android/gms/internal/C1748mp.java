package com.google.android.gms.internal;

import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzm;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.mp */
class C1748mp extends zzk {

    /* renamed from: a */
    private final zzkn.zza f5354a;

    /* renamed from: b */
    private final zzm.zzb f5355b;

    public C1748mp(String str, zzkn.zza zza, zzm.zzb zzb) {
        super(0, str, new C1749mq(zzb, zza));
        this.f5354a = zza;
        this.f5355b = zzb;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzm mo7492a(zzi zzi) {
        return zzm.zza(new ByteArrayInputStream(zzi.data), zzx.zzb(zzi));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7494a(InputStream inputStream) {
        this.f5355b.zzb(this.f5354a.zzh(inputStream));
    }
}
