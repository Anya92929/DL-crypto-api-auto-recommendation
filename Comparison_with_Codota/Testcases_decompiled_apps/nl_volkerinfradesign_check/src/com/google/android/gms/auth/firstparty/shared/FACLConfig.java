package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class FACLConfig implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a */
    final int f2534a;

    /* renamed from: b */
    boolean f2535b;

    /* renamed from: c */
    String f2536c;

    /* renamed from: d */
    boolean f2537d;

    /* renamed from: e */
    boolean f2538e;

    /* renamed from: f */
    boolean f2539f;

    /* renamed from: g */
    boolean f2540g;

    FACLConfig(int i, boolean z, String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f2534a = i;
        this.f2535b = z;
        this.f2536c = str;
        this.f2537d = z2;
        this.f2538e = z3;
        this.f2539f = z4;
        this.f2540g = z5;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FACLConfig)) {
            return false;
        }
        FACLConfig fACLConfig = (FACLConfig) obj;
        return this.f2535b == fACLConfig.f2535b && TextUtils.equals(this.f2536c, fACLConfig.f2536c) && this.f2537d == fACLConfig.f2537d && this.f2538e == fACLConfig.f2538e && this.f2539f == fACLConfig.f2539f && this.f2540g == fACLConfig.f2540g;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.f2535b), this.f2536c, Boolean.valueOf(this.f2537d), Boolean.valueOf(this.f2538e), Boolean.valueOf(this.f2539f), Boolean.valueOf(this.f2540g));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m3646a(this, parcel, i);
    }
}
