package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zzin;

@zzin
public class zze extends zzd {

    /* renamed from: a */
    final int f3953a;

    public zze(Context context, Looper looper, zzd.zzb zzb, zzd.zzc zzc, int i) {
        super(context, looper, 8, zzb, zzc, (String) null);
        this.f3953a = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzk zzbb(IBinder iBinder) {
        return zzk.zza.zzbc(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo5671a() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    /* access modifiers changed from: protected */
    public String zzqz() {
        return "com.google.android.gms.ads.service.START";
    }

    public zzk zzrb() {
        return (zzk) super.zzasa();
    }
}
