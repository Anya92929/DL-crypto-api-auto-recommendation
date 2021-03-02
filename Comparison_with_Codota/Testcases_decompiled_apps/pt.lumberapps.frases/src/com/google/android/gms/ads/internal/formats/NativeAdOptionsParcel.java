package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzin;

@zzin
public class NativeAdOptionsParcel extends AbstractSafeParcelable {
    public static final zzj CREATOR = new zzj();
    public final int versionCode;
    public final boolean zzbgp;
    public final int zzbgq;
    public final boolean zzbgr;
    public final int zzbgs;

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2, int i3) {
        this.versionCode = i;
        this.zzbgp = z;
        this.zzbgq = i2;
        this.zzbgr = z2;
        this.zzbgs = i3;
    }

    public NativeAdOptionsParcel(NativeAdOptions nativeAdOptions) {
        this(2, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.m5625a(this, parcel, i);
    }
}
