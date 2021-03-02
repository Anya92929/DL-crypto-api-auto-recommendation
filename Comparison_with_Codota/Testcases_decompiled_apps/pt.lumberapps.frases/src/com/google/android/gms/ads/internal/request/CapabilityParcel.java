package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzin;

@zzin
public class CapabilityParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzj();
    public final int versionCode;
    public final boolean zzccw;
    public final boolean zzccx;
    public final boolean zzccy;

    CapabilityParcel(int i, boolean z, boolean z2, boolean z3) {
        this.versionCode = i;
        this.zzccw = z;
        this.zzccx = z2;
        this.zzccy = z3;
    }

    public CapabilityParcel(boolean z, boolean z2, boolean z3) {
        this(2, z, z2, z3);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.zzccw);
        bundle.putBoolean("default_iap_supported", this.zzccx);
        bundle.putBoolean("app_streaming_supported", this.zzccy);
        return bundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.m5752a(this, parcel, i);
    }
}
