package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzlh;

@zzin
public abstract class zzj {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5509a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return zzs.zzavq() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5510a(zzlh zzlh) {
        return zzlh.zzdn().zzaus;
    }

    public abstract zzi zza(Context context, zzlh zzlh, int i, boolean z, zzdk zzdk, zzdi zzdi);
}
