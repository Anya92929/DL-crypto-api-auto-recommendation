package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzin;

@zzin
public class StringParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzo();

    /* renamed from: a */
    final int f3909a;

    /* renamed from: b */
    String f3910b;

    StringParcel(int i, String str) {
        this.f3909a = i;
        this.f3910b = str;
    }

    public StringParcel(String str) {
        this.f3909a = 1;
        this.f3910b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.m5763a(this, parcel, i);
    }

    public String zzre() {
        return this.f3910b;
    }
}
