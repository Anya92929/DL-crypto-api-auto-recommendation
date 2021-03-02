package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.zzin;

@zzin
public class zzb {
    /* renamed from: e */
    public static void m5769e(String str) {
        if (zzaz(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void zza(String str, Throwable th) {
        if (zzaz(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean zzaz(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }

    public static void zzb(String str, Throwable th) {
        if (zzaz(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (zzaz(4)) {
            Log.i(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzcv(String str) {
        if (zzaz(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void zzcw(String str) {
        if (zzaz(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void zzcx(String str) {
        if (zzaz(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    public static void zzd(String str, Throwable th) {
        if (zzaz(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }
}
