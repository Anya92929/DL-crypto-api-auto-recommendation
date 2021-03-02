package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.flags.impl.zza;
import com.google.android.gms.internal.zzty;

@DynamiteApi
public class FlagProviderImpl extends zzty.zza {

    /* renamed from: a */
    private boolean f4786a = false;

    /* renamed from: b */
    private SharedPreferences f4787b;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f4786a ? z : zza.C2111zza.zza(this.f4787b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f4786a ? i : zza.zzb.zza(this.f4787b, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.f4786a ? j : zza.zzc.zza(this.f4787b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f4786a ? str2 : zza.zzd.zza(this.f4787b, str, str2);
    }

    public void init(zzd zzd) {
        Context context = (Context) zze.zzad(zzd);
        if (!this.f4786a) {
            try {
                this.f4787b = zzb.zzn(context.createPackageContext("com.google.android.gms", 0));
                this.f4786a = true;
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
    }
}
