package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzli;

@zzin
public class zzid extends zzhy implements zzli.zza {
    zzid(Context context, zzju.zza zza, zzlh zzlh, zzic.zza zza2) {
        super(context, zza, zzlh, zza2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8486a() {
        if (this.f6359e.errorCode == -2) {
            this.f6357c.zzuj().zza((zzli.zza) this);
            mo8508c();
            zzkd.zzcv("Loading HTML in WebView.");
            this.f6357c.loadDataWithBaseURL(zzu.zzfq().zzco(this.f6359e.zzbto), this.f6359e.body, "text/html", "UTF-8", (String) null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8508c() {
    }
}
