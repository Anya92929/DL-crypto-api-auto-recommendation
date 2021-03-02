package com.google.android.gms.gass.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.gass.internal.zze;

public class zzb extends zzd {
    public zzb(Context context, Looper looper, zzd.zzb zzb, zzd.zzc zzc) {
        super(context, looper, 116, zzb, zzc, (String) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zze zzbb(IBinder iBinder) {
        return zze.zza.zzgl(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo5671a() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    public zze zzblb() {
        return (zze) super.zzasa();
    }

    /* access modifiers changed from: protected */
    public String zzqz() {
        return "com.google.android.gms.gass.START";
    }
}
