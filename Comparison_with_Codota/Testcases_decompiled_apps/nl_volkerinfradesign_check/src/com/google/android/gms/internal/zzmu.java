package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzmu {
    @TargetApi(13)
    /* renamed from: a */
    private static boolean m4063a(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return zzne.zzsf() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }

    @TargetApi(20)
    public static boolean zzaw(Context context) {
        return zzne.zzsl() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static boolean zzb(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (zzne.zzsd() && ((resources.getConfiguration().screenLayout & 15) > 3)) || m4063a(resources);
    }
}
