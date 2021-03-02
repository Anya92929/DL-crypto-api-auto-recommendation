package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzlh;

@zzin
public class zzn extends zzj {
    public zzi zza(Context context, zzlh zzlh, int i, boolean z, zzdk zzdk, zzdi zzdi) {
        if (!mo5509a(context)) {
            return null;
        }
        return new zzc(context, z, mo5510a(zzlh), new zzx(context, zzlh.zzum(), zzlh.getRequestId(), zzdk, zzdi));
    }
}
