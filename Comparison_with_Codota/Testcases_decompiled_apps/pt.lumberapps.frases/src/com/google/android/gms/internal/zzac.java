package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import java.io.File;

public class zzac {
    public static zzl zza(Context context) {
        return zza(context, (zzy) null);
    }

    public static zzl zza(Context context, zzy zzy) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = new StringBuilder(String.valueOf(packageName).length() + 12).append(packageName).append("/").append(context.getPackageManager().getPackageInfo(packageName, 0).versionCode).toString();
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (zzy == null) {
            zzy = Build.VERSION.SDK_INT >= 9 ? new zzz() : new zzw(AndroidHttpClient.newInstance(str));
        }
        zzl zzl = new zzl(new zzv(file), new zzt(zzy));
        zzl.start();
        return zzl;
    }
}
