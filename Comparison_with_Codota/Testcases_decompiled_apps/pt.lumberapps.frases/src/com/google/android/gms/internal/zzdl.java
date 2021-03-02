package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdn;

@zzin
public final class zzdl extends zzdn.zza {

    /* renamed from: a */
    private final zzh f6126a;

    /* renamed from: b */
    private final String f6127b;

    /* renamed from: c */
    private final String f6128c;

    public zzdl(zzh zzh, String str, String str2) {
        this.f6126a = zzh;
        this.f6127b = str;
        this.f6128c = str2;
    }

    public String getContent() {
        return this.f6128c;
    }

    public void recordClick() {
        this.f6126a.zzeh();
    }

    public void recordImpression() {
        this.f6126a.zzei();
    }

    public void zzi(zzd zzd) {
        if (zzd != null) {
            this.f6126a.zzc((View) zze.zzad(zzd));
        }
    }

    public String zzkk() {
        return this.f6127b;
    }
}
