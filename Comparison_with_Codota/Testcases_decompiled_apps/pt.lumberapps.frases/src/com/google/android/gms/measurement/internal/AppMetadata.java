package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public class AppMetadata extends AbstractSafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final String aav;
    public final String aic;
    public final String aid;
    public final long aie;
    public final long aif;
    public final String aig;
    public final boolean aih;
    public final boolean aii;
    public final long aij;
    public final String aik;
    public final String packageName;
    public final int versionCode;

    AppMetadata(int i, String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6) {
        this.versionCode = i;
        this.packageName = str;
        this.aic = str2;
        this.aav = str3;
        this.aij = i < 5 ? -2147483648L : j3;
        this.aid = str4;
        this.aie = j;
        this.aif = j2;
        this.aig = str5;
        if (i >= 3) {
            this.aih = z;
        } else {
            this.aih = true;
        }
        this.aii = z2;
        this.aik = str6;
    }

    AppMetadata(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6) {
        zzab.zzhr(str);
        this.versionCode = 6;
        this.packageName = str;
        this.aic = TextUtils.isEmpty(str2) ? null : str2;
        this.aav = str3;
        this.aij = j;
        this.aid = str4;
        this.aie = j2;
        this.aif = j3;
        this.aig = str5;
        this.aih = z;
        this.aii = z2;
        this.aik = str6;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m7813a(this, parcel, i);
    }
}
