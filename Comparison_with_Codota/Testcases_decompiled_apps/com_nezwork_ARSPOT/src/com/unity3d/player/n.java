package com.unity3d.player;

import android.os.Build;

public final class n {
    static final boolean a = (Build.VERSION.SDK_INT >= 11);
    static final j b = (a ? new j() : null);
    private static boolean c = (Build.VERSION.SDK_INT >= 5);
    private static boolean d = (Build.VERSION.SDK_INT >= 8);
    private static boolean e = (Build.VERSION.SDK_INT >= 12);
    private static boolean f;

    static {
        boolean z = true;
        int i = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT < 14) {
            z = false;
        }
        f = z;
        if (c) {
            new f();
        }
        if (d) {
            new g();
        }
        if (e) {
            new i();
        }
        if (f) {
            new k();
        }
    }
}
