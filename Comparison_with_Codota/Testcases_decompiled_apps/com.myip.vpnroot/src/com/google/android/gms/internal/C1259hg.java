package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.hg */
public class C1259hg implements SafeParcelable {
    public static final C1260hh CREATOR = new C1260hh();

    /* renamed from: BR */
    final int f3843BR;

    /* renamed from: BZ */
    final String f3844BZ;

    /* renamed from: Ca */
    final String f3845Ca;

    /* renamed from: Cb */
    final String f3846Cb;

    C1259hg(int i, String str, String str2, String str3) {
        this.f3843BR = i;
        this.f3844BZ = str;
        this.f3845Ca = str2;
        this.f3846Cb = str3;
    }

    public C1259hg(String str, String str2, String str3) {
        this(1, str, str2, str3);
    }

    public int describeContents() {
        C1260hh hhVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.f3844BZ, this.f3845Ca, this.f3846Cb});
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1260hh hhVar = CREATOR;
        C1260hh.m4766a(this, dest, flags);
    }
}
