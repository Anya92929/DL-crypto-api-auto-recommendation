package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationAvailability implements SafeParcelable {
    public static final C1117f CREATOR = new C1117f();

    /* renamed from: a */
    int f4890a;

    /* renamed from: b */
    int f4891b;

    /* renamed from: c */
    long f4892c;

    /* renamed from: d */
    int f4893d;

    /* renamed from: e */
    private final int f4894e;

    LocationAvailability(int i, int i2, int i3, int i4, long j) {
        this.f4894e = i;
        this.f4893d = i2;
        this.f4890a = i3;
        this.f4891b = i4;
        this.f4892c = j;
    }

    /* renamed from: a */
    public boolean mo7736a() {
        return this.f4893d < 1000;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo7737b() {
        return this.f4894e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.f4893d == locationAvailability.f4893d && this.f4890a == locationAvailability.f4890a && this.f4891b == locationAvailability.f4891b && this.f4892c == locationAvailability.f4892c;
    }

    public int hashCode() {
        return C1006bc.m4523a(Integer.valueOf(this.f4893d), Integer.valueOf(this.f4890a), Integer.valueOf(this.f4891b), Long.valueOf(this.f4892c));
    }

    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + mo7736a() + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1117f.m4836a(this, parcel, i);
    }
}
