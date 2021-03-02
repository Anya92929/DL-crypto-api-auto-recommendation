package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@zzin
public abstract class zzix {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8548a(zzir zzir) {
        zzir.zzri();
        if (zzir.zzrg() != null) {
            zzir.zzrg().release();
        }
    }

    public abstract void zza(Context context, zzir zzir, VersionInfoParcel versionInfoParcel);
}
