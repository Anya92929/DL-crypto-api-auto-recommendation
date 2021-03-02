package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;

@zzin
public class zzk {

    /* renamed from: a */
    private final String f3899a;

    public zzk(String str) {
        this.f3899a = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String zze = zzu.zzga().zze(intent);
        String zzf = zzu.zzga().zzf(intent);
        if (zze == null || zzf == null) {
            return false;
        }
        if (!str.equals(zzu.zzga().zzby(zze))) {
            zzkd.zzcx("Developer payload not match.");
            return false;
        } else if (this.f3899a == null || zzl.zzc(this.f3899a, zze, zzf)) {
            return true;
        } else {
            zzkd.zzcx("Fail to verify signature.");
            return false;
        }
    }

    public String zzpu() {
        return zzu.zzfq().zztf();
    }
}
