package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@C1130ez
/* renamed from: com.google.android.gms.internal.gt */
public final class C1230gt implements SafeParcelable {
    public static final C1231gu CREATOR = new C1231gu();
    public final int versionCode;

    /* renamed from: wD */
    public String f3777wD;

    /* renamed from: wE */
    public int f3778wE;

    /* renamed from: wF */
    public int f3779wF;

    /* renamed from: wG */
    public boolean f3780wG;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C1230gt(int i, int i2, boolean z) {
        this(1, "afma-sdk-a-v" + i + "." + i2 + "." + (z ? "0" : "1"), i, i2, z);
    }

    C1230gt(int i, String str, int i2, int i3, boolean z) {
        this.versionCode = i;
        this.f3777wD = str;
        this.f3778wE = i2;
        this.f3779wF = i3;
        this.f3780wG = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1231gu.m4685a(this, out, flags);
    }
}
