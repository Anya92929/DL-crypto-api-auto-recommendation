package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzca;

public final class zzby extends zzca.zza {

    /* renamed from: a */
    private final zzar f5990a;

    /* renamed from: b */
    private final zzas f5991b;

    /* renamed from: c */
    private final zzap f5992c;

    /* renamed from: d */
    private boolean f5993d = false;

    public zzby(String str, Context context, boolean z) {
        this.f5990a = zzar.zza(str, context, z);
        this.f5991b = new zzas(this.f5990a);
        this.f5992c = z ? null : zzap.zze(context);
    }

    /* renamed from: a */
    private zzd m6919a(zzd zzd, zzd zzd2, boolean z) {
        try {
            Uri uri = (Uri) zze.zzad(zzd);
            Context context = (Context) zze.zzad(zzd2);
            return zze.zzac(z ? this.f5991b.zza(uri, context) : this.f5991b.zzb(uri, context));
        } catch (zzat e) {
            return null;
        }
    }

    public zzd zza(zzd zzd, zzd zzd2) {
        return m6919a(zzd, zzd2, true);
    }

    public String zza(zzd zzd, String str) {
        return this.f5990a.zzb((Context) zze.zzad(zzd), str);
    }

    public boolean zza(zzd zzd) {
        return this.f5991b.zza((Uri) zze.zzad(zzd));
    }

    public zzd zzb(zzd zzd, zzd zzd2) {
        return m6919a(zzd, zzd2, false);
    }

    public void zzb(String str, String str2) {
        this.f5991b.zzb(str, str2);
    }

    public boolean zzb(zzd zzd) {
        return this.f5991b.zzc((Uri) zze.zzad(zzd));
    }

    public boolean zzb(String str, boolean z) {
        if (this.f5992c == null) {
            return false;
        }
        this.f5992c.zza(new AdvertisingIdClient.Info(str, z));
        this.f5993d = true;
        return true;
    }

    public String zzc(zzd zzd) {
        Context context = (Context) zze.zzad(zzd);
        String zzb = this.f5990a.zzb(context);
        if (this.f5992c == null || !this.f5993d) {
            return zzb;
        }
        String zza = this.f5992c.zza(zzb, this.f5992c.zzb(context));
        this.f5993d = false;
        return zza;
    }

    public void zzd(zzd zzd) {
        this.f5991b.zza((MotionEvent) zze.zzad(zzd));
    }

    public String zzdf() {
        return "ms";
    }

    public void zzk(String str) {
        this.f5991b.zzk(str);
    }
}
