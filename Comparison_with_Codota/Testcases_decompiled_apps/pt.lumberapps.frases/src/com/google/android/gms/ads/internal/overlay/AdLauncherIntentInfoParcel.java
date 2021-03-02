package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzin;

@zzin
public final class AdLauncherIntentInfoParcel extends AbstractSafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final Intent intent;
    public final String mimeType;
    public final String packageName;
    public final String url;
    public final int versionCode;
    public final String zzbrn;
    public final String zzbro;
    public final String zzbrp;
    public final String zzbrq;

    public AdLauncherIntentInfoParcel(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent2) {
        this.versionCode = i;
        this.zzbrn = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzbro = str5;
        this.zzbrp = str6;
        this.zzbrq = str7;
        this.intent = intent2;
    }

    public AdLauncherIntentInfoParcel(Intent intent2) {
        this(2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, intent2);
    }

    public AdLauncherIntentInfoParcel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(2, str, str2, str3, str4, str5, str6, str7, (Intent) null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m5651a(this, parcel, i);
    }
}
