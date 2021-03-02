package com.google.android.gms.vision.barcode.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BarcodeDetectorOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    final int versionCode;
    public int zzbnw;

    public BarcodeDetectorOptions() {
        this.versionCode = 1;
    }

    public BarcodeDetectorOptions(int versionCode2, int barcodeFormats) {
        this.versionCode = versionCode2;
        this.zzbnw = barcodeFormats;
    }

    public int describeContents() {
        zza zza = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza zza = CREATOR;
        zza.zza(this, parcel, flags);
    }
}
