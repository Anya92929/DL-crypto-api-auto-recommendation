package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzu;

@zzin
public class zzlj {
    public zzlh zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzas zzas, VersionInfoParcel versionInfoParcel) {
        return zza(context, adSizeParcel, z, z2, zzas, versionInfoParcel, (zzdk) null, (zzs) null, (zzd) null);
    }

    public zzlh zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzas zzas, VersionInfoParcel versionInfoParcel, zzdk zzdk, zzs zzs, zzd zzd) {
        C1764ne neVar = new C1764ne(zzll.m7349a(context, adSizeParcel, z, z2, zzas, versionInfoParcel, zzdk, zzs, zzd));
        neVar.setWebViewClient(zzu.zzfs().zzb((zzlh) neVar, z2));
        neVar.setWebChromeClient(zzu.zzfs().zzk(neVar));
        return neVar;
    }
}
