package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzi {

    /* renamed from: a */
    private static Boolean f4726a;

    /* renamed from: b */
    private static Boolean f4727b;

    /* renamed from: c */
    private static Boolean f4728c;

    /* renamed from: d */
    private static Boolean f4729d;

    @TargetApi(13)
    /* renamed from: a */
    private static boolean m6200a(Resources resources) {
        if (f4727b == null) {
            Configuration configuration = resources.getConfiguration();
            f4727b = Boolean.valueOf(zzs.zzavp() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600);
        }
        return f4727b.booleanValue();
    }

    public static boolean zzb(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (f4726a == null) {
            boolean z2 = (resources.getConfiguration().screenLayout & 15) > 3;
            if ((zzs.zzavn() && z2) || m6200a(resources)) {
                z = true;
            }
            f4726a = Boolean.valueOf(z);
        }
        return f4726a.booleanValue();
    }

    @TargetApi(20)
    public static boolean zzck(Context context) {
        if (f4728c == null) {
            f4728c = Boolean.valueOf(zzs.zzavv() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f4728c.booleanValue();
    }

    @TargetApi(21)
    public static boolean zzcl(Context context) {
        if (f4729d == null) {
            f4729d = Boolean.valueOf(zzs.zzavx() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f4729d.booleanValue();
    }
}
