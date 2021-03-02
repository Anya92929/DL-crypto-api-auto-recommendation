package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;

@TargetApi(11)
/* renamed from: com.google.android.gms.common.images.a */
final class C1351a {
    /* renamed from: a */
    static int m6032a(ActivityManager activityManager) {
        return activityManager.getLargeMemoryClass();
    }
}
