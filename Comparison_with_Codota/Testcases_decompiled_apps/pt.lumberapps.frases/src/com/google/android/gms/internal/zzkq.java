package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzc;
import com.google.android.gms.ads.internal.zzu;

@zzin
public final class zzkq extends zzkc {

    /* renamed from: a */
    private final zzc f6640a;

    /* renamed from: b */
    private final String f6641b;

    public zzkq(Context context, String str, String str2) {
        this(str2, zzu.zzfq().zzg(context, str));
    }

    public zzkq(String str, String str2) {
        this.f6640a = new zzc(str2);
        this.f6641b = str;
    }

    public void onStop() {
    }

    public void zzew() {
        this.f6640a.zzcr(this.f6641b);
    }
}
