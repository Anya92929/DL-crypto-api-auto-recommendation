package com.google.android.gms.p018c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import com.google.android.gms.common.internal.C1015f;

/* renamed from: com.google.android.gms.c.ac */
public class C0614ac {
    /* renamed from: a */
    public static boolean m3553a() {
        return C1015f.f4727a && C0669k.m3888b() && C0669k.m3882a() == Process.myUid();
    }

    /* renamed from: a */
    public static boolean m3554a(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
