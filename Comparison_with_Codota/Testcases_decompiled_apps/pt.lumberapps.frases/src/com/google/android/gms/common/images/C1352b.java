package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.p009v4.p019f.C0142g;
import com.google.android.gms.common.util.zzs;

/* renamed from: com.google.android.gms.common.images.b */
final class C1352b extends C0142g {
    public C1352b(Context context) {
        super(m6033a(context));
    }

    @TargetApi(11)
    /* renamed from: a */
    private static int m6033a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        return (int) (((float) (((!((context.getApplicationInfo().flags & 1048576) != 0) || !zzs.zzavn()) ? activityManager.getMemoryClass() : C1351a.m6032a(activityManager)) * 1048576)) * 0.33f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo1063a(C1357g gVar, Bitmap bitmap) {
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1065a(boolean z, C1357g gVar, Bitmap bitmap, Bitmap bitmap2) {
        super.mo1065a(z, gVar, bitmap, bitmap2);
    }
}
