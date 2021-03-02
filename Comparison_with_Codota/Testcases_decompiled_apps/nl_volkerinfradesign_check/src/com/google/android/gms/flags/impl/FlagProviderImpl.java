package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.flags.impl.zza;
import com.google.android.gms.internal.zzpk;

public class FlagProviderImpl extends zzpk.zza {

    /* renamed from: a */
    private boolean f3146a = false;

    /* renamed from: b */
    private SharedPreferences f3147b;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return zza.C2022zza.zza(this.f3147b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return zza.zzb.zza(this.f3147b, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return zza.zzc.zza(this.f3147b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return zza.zzd.zza(this.f3147b, str, str2);
    }

    public void init(zzd zzd) {
        Context context = (Context) zze.zzp(zzd);
        if (!this.f3146a) {
            try {
                this.f3147b = zzb.zzw(context.createPackageContext("com.google.android.gms", 0));
                this.f3146a = true;
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
    }
}
