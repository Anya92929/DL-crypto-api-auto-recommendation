package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zziv;
import java.util.WeakHashMap;

@zzin
public final class zziw {

    /* renamed from: a */
    private WeakHashMap f6502a = new WeakHashMap();

    public zziv zzy(Context context) {
        C1707lb lbVar = (C1707lb) this.f6502a.get(context);
        zziv zzrn = (lbVar == null || lbVar.mo7461a() || !((Boolean) zzdc.zzbas.get()).booleanValue()) ? new zziv.zza(context).zzrn() : new zziv.zza(context, lbVar.f5274b).zzrn();
        this.f6502a.put(context, new C1707lb(this, zzrn));
        return zzrn;
    }
}
