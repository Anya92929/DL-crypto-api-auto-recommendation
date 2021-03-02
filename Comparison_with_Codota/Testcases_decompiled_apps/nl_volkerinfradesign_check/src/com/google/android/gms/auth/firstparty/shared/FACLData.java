package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData implements SafeParcelable {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a */
    final int f2541a;

    /* renamed from: b */
    FACLConfig f2542b;

    /* renamed from: c */
    String f2543c;

    /* renamed from: d */
    boolean f2544d;

    /* renamed from: e */
    String f2545e;

    FACLData(int i, FACLConfig fACLConfig, String str, boolean z, String str2) {
        this.f2541a = i;
        this.f2542b = fACLConfig;
        this.f2543c = str;
        this.f2544d = z;
        this.f2545e = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m3647a(this, parcel, i);
    }
}
