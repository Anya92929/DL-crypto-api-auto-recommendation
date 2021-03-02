package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.measurement.internal.zzm;

public class zzo extends zzd {
    public zzo(Context context, Looper looper, zzd.zzb zzb, zzd.zzc zzc) {
        super(context, looper, 93, zzb, zzc, (String) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo5671a() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    /* renamed from: zzjg */
    public zzm zzbb(IBinder iBinder) {
        return zzm.zza.zzjf(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzqz() {
        return "com.google.android.gms.measurement.START";
    }
}
