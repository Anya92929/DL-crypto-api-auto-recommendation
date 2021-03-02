package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.ig */
public class C1314ig implements SafeParcelable {
    public static final Parcelable.Creator<C1314ig> CREATOR = new C1315ih();

    /* renamed from: BR */
    private final int f3971BR;

    /* renamed from: Gn */
    private String f3972Gn;

    public C1314ig() {
        this(1, (String) null);
    }

    C1314ig(int i, String str) {
        this.f3971BR = i;
        this.f3972Gn = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1314ig)) {
            return false;
        }
        return C1326ik.m4984a(this.f3972Gn, ((C1314ig) obj).f3972Gn);
    }

    /* renamed from: fz */
    public String mo8826fz() {
        return this.f3972Gn;
    }

    public int getVersionCode() {
        return this.f3971BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f3972Gn);
    }

    public void writeToParcel(Parcel out, int flags) {
        C1315ih.m4916a(this, out, flags);
    }
}
