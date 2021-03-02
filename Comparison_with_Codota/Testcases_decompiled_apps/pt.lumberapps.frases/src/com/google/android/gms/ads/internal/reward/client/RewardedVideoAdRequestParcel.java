package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzin;

@zzin
public final class RewardedVideoAdRequestParcel extends AbstractSafeParcelable {
    public static final zzh CREATOR = new zzh();
    public final int versionCode;
    public final String zzaou;
    public final AdRequestParcel zzcar;

    public RewardedVideoAdRequestParcel(int i, AdRequestParcel adRequestParcel, String str) {
        this.versionCode = i;
        this.zzcar = adRequestParcel;
        this.zzaou = str;
    }

    public RewardedVideoAdRequestParcel(AdRequestParcel adRequestParcel, String str) {
        this(1, adRequestParcel, str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.m5765a(this, parcel, i);
    }
}
