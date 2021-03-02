package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzin;

@zzin
public class ThinAdSizeParcel extends AdSizeParcel {
    public ThinAdSizeParcel(AdSizeParcel adSizeParcel) {
        super(adSizeParcel.versionCode, adSizeParcel.zzaur, adSizeParcel.height, adSizeParcel.heightPixels, adSizeParcel.zzaus, adSizeParcel.width, adSizeParcel.widthPixels, adSizeParcel.zzaut, adSizeParcel.zzauu, adSizeParcel.zzauv, adSizeParcel.zzauw);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, this.versionCode);
        zzb.zza(parcel, 2, this.zzaur, false);
        zzb.zzc(parcel, 3, this.height);
        zzb.zzc(parcel, 6, this.width);
        zzb.zzaj(parcel, zzcn);
    }
}
