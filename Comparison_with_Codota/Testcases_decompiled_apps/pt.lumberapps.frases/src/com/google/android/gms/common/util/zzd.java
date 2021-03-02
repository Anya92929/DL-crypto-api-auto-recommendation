package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.p009v4.app.NotificationCompat;
import com.google.android.gms.internal.zzrp;

public class zzd {
    public static int zza(PackageInfo packageInfo) {
        Bundle bundle;
        if (packageInfo == null || packageInfo.applicationInfo == null || (bundle = packageInfo.applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    public static boolean zzabc() {
        return false;
    }

    public static int zzo(Context context, String str) {
        return zza(zzp(context, str));
    }

    public static PackageInfo zzp(Context context, String str) {
        try {
            return zzrp.zzcq(context).getPackageInfo(str, NotificationCompat.FLAG_HIGH_PRIORITY);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    @TargetApi(12)
    public static boolean zzq(Context context, String str) {
        if (!zzs.zzavo()) {
            return false;
        }
        if ("com.google.android.gms".equals(str) && zzabc()) {
            return false;
        }
        try {
            return (zzrp.zzcq(context).getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
