package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.be */
public final class C0279be implements SafeParcelable {
    public static final C0278bd CREATOR = new C0278bd();

    /* renamed from: fA */
    public final String f841fA;

    /* renamed from: fB */
    public final String f842fB;

    /* renamed from: fC */
    public final String f843fC;

    /* renamed from: fy */
    public final String f844fy;

    /* renamed from: fz */
    public final String f845fz;
    public final String mimeType;
    public final String packageName;
    public final int versionCode;

    public C0279be(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.versionCode = i;
        this.f844fy = str;
        this.f845fz = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.f841fA = str5;
        this.f842fB = str6;
        this.f843fC = str7;
    }

    public C0279be(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(1, str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0278bd.m561a(this, out, flags);
    }
}
