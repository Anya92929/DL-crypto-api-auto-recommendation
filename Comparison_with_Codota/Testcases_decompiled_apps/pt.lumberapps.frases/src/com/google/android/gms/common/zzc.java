package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.p021v7.p023b.C0515k;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.util.zzi;

public class zzc {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* renamed from: a */
    private static final zzc f4748a = new zzc();

    zzc() {
    }

    /* renamed from: a */
    private String m6212a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return sb.toString();
    }

    public static zzc zzang() {
        return f4748a;
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return zza(context, i, i2, (String) null);
    }

    public String getErrorString(int i) {
        return zze.getErrorString(i);
    }

    public String getOpenSourceSoftwareLicenseInfo(Context context) {
        return zze.getOpenSourceSoftwareLicenseInfo(context);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        int isGooglePlayServicesAvailable = zze.isGooglePlayServicesAvailable(context);
        if (zze.zzc(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    public boolean isUserResolvableError(int i) {
        return zze.isUserRecoverableError(i);
    }

    public PendingIntent zza(Context context, int i, int i2, String str) {
        if (zzi.zzck(context) && i == 2) {
            i = 42;
        }
        Intent zza = zza(context, i, str);
        if (zza == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, zza, 268435456);
    }

    public Intent zza(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return zzo.zzad("com.google.android.gms", m6212a(context, str));
            case 3:
                return zzo.zzho("com.google.android.gms");
            case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                return zzo.zzata();
            default:
                return null;
        }
    }

    public int zzbn(Context context) {
        return zze.zzbn(context);
    }

    public void zzbo(Context context) {
        zze.zzbb(context);
    }

    public void zzbp(Context context) {
        zze.zzbp(context);
    }

    public boolean zzc(Context context, int i) {
        return zze.zzc(context, i);
    }

    @Deprecated
    public Intent zzfc(int i) {
        return zza((Context) null, i, (String) null);
    }

    public boolean zzl(Context context, String str) {
        return zze.m6216a(context, str);
    }
}
