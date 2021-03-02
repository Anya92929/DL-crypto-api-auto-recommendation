package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.co */
public final class C0345co implements SafeParcelable {
    public static final C0346cp CREATOR = new C0346cp();

    /* renamed from: hP */
    public String f1014hP;

    /* renamed from: hQ */
    public int f1015hQ;

    /* renamed from: hR */
    public int f1016hR;

    /* renamed from: hS */
    public boolean f1017hS;
    public final int versionCode;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C0345co(int i, int i2, boolean z) {
        this(1, "afma-sdk-a-v" + i + "." + i2 + "." + (z ? "0" : "1"), i, i2, z);
    }

    C0345co(int i, String str, int i2, int i3, boolean z) {
        this.versionCode = i;
        this.f1014hP = str;
        this.f1015hQ = i2;
        this.f1016hR = i3;
        this.f1017hS = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0346cp.m738a(this, out, flags);
    }
}
