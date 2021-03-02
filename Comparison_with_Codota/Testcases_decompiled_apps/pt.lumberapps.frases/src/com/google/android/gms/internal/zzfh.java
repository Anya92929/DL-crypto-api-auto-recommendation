package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzl;

@zzin
public class zzfh {

    /* renamed from: a */
    private Context f6179a;

    /* renamed from: b */
    private final zzgj f6180b;

    /* renamed from: c */
    private final VersionInfoParcel f6181c;

    /* renamed from: d */
    private final zzd f6182d;

    zzfh(Context context, zzgj zzgj, VersionInfoParcel versionInfoParcel, zzd zzd) {
        this.f6179a = context;
        this.f6180b = zzgj;
        this.f6181c = versionInfoParcel;
        this.f6182d = zzd;
    }

    public Context getApplicationContext() {
        return this.f6179a.getApplicationContext();
    }

    public zzl zzbc(String str) {
        return new zzl(this.f6179a, new AdSizeParcel(), str, this.f6180b, this.f6181c, this.f6182d);
    }

    public zzl zzbd(String str) {
        return new zzl(this.f6179a.getApplicationContext(), new AdSizeParcel(), str, this.f6180b, this.f6181c, this.f6182d);
    }

    public zzfh zzln() {
        return new zzfh(getApplicationContext(), this.f6180b, this.f6181c, this.f6182d);
    }
}
