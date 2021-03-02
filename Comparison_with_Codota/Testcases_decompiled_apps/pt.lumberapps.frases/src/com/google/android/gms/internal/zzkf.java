package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzin
public final class zzkf {

    public interface zzb {
        void zzg(Bundle bundle);
    }

    public static Future zza(Context context, zzb zzb2) {
        return (Future) new C1724ls(context, zzb2).zzpy();
    }

    public static Future zza(Context context, String str, long j) {
        return (Future) new C1722lq(context, str, j).zzpy();
    }

    public static Future zzb(Context context, zzb zzb2) {
        return (Future) new C1725lt(context, zzb2).zzpy();
    }

    public static Future zzc(Context context, zzb zzb2) {
        return (Future) new C1727lv(context, zzb2).zzpy();
    }

    public static Future zzc(Context context, boolean z) {
        return (Future) new C1718lm(context, z).zzpy();
    }

    public static Future zzd(Context context, zzb zzb2) {
        return (Future) new C1719ln(context, zzb2).zzpy();
    }

    public static Future zze(Context context, zzb zzb2) {
        return (Future) new C1721lp(context, zzb2).zzpy();
    }

    public static Future zze(Context context, boolean z) {
        return (Future) new C1726lu(context, z).zzpy();
    }

    public static Future zzf(Context context, zzb zzb2) {
        return (Future) new C1723lr(context, zzb2).zzpy();
    }

    public static Future zzf(Context context, String str) {
        return (Future) new C1728lw(context, str).zzpy();
    }

    public static Future zzf(Context context, boolean z) {
        return (Future) new C1720lo(context, z).zzpy();
    }

    public static SharedPreferences zzn(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
