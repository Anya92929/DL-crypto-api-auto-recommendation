package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FavaDiagnosticsEntity implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a */
    final int f3038a;
    public final String zzamD;
    public final int zzamE;

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.f3038a = i;
        this.zzamD = str;
        this.zzamE = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m3990a(this, parcel, i);
    }
}
