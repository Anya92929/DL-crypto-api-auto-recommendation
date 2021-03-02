package android.support.p003v7.internal;

import android.os.Build;

/* renamed from: android.support.v7.internal.VersionUtils */
public class VersionUtils {
    private VersionUtils() {
    }

    public static boolean isAtLeastL() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
