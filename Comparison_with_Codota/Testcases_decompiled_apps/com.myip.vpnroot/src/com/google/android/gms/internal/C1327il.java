package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.il */
public class C1327il implements SafeParcelable {
    public static final Parcelable.Creator<C1327il> CREATOR = new C1328im();

    /* renamed from: BR */
    private final int f4018BR;

    /* renamed from: FA */
    private double f4019FA;

    /* renamed from: FB */
    private boolean f4020FB;

    /* renamed from: GB */
    private int f4021GB;

    /* renamed from: GC */
    private int f4022GC;

    /* renamed from: GN */
    private ApplicationMetadata f4023GN;

    public C1327il() {
        this(3, Double.NaN, false, -1, (ApplicationMetadata) null, -1);
    }

    C1327il(int i, double d, boolean z, int i2, ApplicationMetadata applicationMetadata, int i3) {
        this.f4018BR = i;
        this.f4019FA = d;
        this.f4020FB = z;
        this.f4021GB = i2;
        this.f4023GN = applicationMetadata;
        this.f4022GC = i3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1327il)) {
            return false;
        }
        C1327il ilVar = (C1327il) obj;
        return this.f4019FA == ilVar.f4019FA && this.f4020FB == ilVar.f4020FB && this.f4021GB == ilVar.f4021GB && C1326ik.m4984a(this.f4023GN, ilVar.f4023GN) && this.f4022GC == ilVar.f4022GC;
    }

    /* renamed from: fF */
    public double mo8878fF() {
        return this.f4019FA;
    }

    /* renamed from: fN */
    public boolean mo8879fN() {
        return this.f4020FB;
    }

    /* renamed from: fO */
    public int mo8880fO() {
        return this.f4021GB;
    }

    /* renamed from: fP */
    public int mo8881fP() {
        return this.f4022GC;
    }

    public ApplicationMetadata getApplicationMetadata() {
        return this.f4023GN;
    }

    public int getVersionCode() {
        return this.f4018BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Double.valueOf(this.f4019FA), Boolean.valueOf(this.f4020FB), Integer.valueOf(this.f4021GB), this.f4023GN, Integer.valueOf(this.f4022GC));
    }

    public void writeToParcel(Parcel out, int flags) {
        C1328im.m4994a(this, out, flags);
    }
}
