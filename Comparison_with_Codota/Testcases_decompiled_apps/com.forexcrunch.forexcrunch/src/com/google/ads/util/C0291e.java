package com.google.ads.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;

@TargetApi(4)
/* renamed from: com.google.ads.util.e */
public final class C0291e {
    /* renamed from: a */
    public static int m498a(Context context, DisplayMetrics displayMetrics) {
        return m497a(context, displayMetrics.density, displayMetrics.heightPixels);
    }

    /* renamed from: b */
    public static int m500b(Context context, DisplayMetrics displayMetrics) {
        return m497a(context, displayMetrics.density, displayMetrics.widthPixels);
    }

    /* renamed from: a */
    private static int m497a(Context context, float f, int i) {
        if ((context.getApplicationInfo().flags & 8192) != 0) {
            return (int) (((float) i) / f);
        }
        return i;
    }

    /* renamed from: a */
    public static void m499a(Intent intent, String str) {
        intent.setPackage(str);
    }
}
