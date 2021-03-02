package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ms */
public final class C1570ms implements SafeParcelable {
    public static final C1571mt CREATOR = new C1571mt();
    public static final C1570ms ahR = m5633y("test_type", 1);
    public static final C1570ms ahS = m5633y("trellis_store", 2);
    public static final C1570ms ahT = m5633y("labeled_place", 6);
    public static final Set<C1570ms> ahU = Collections.unmodifiableSet(new HashSet(Arrays.asList(new C1570ms[]{ahR, ahS, ahT})));

    /* renamed from: BR */
    final int f4291BR;
    final int ahV;

    /* renamed from: uO */
    final String f4292uO;

    C1570ms(int i, String str, int i2) {
        C0348n.m856aZ(str);
        this.f4291BR = i;
        this.f4292uO = str;
        this.ahV = i2;
    }

    /* renamed from: y */
    private static C1570ms m5633y(String str, int i) {
        return new C1570ms(0, str, i);
    }

    public int describeContents() {
        C1571mt mtVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof C1570ms)) {
            return false;
        }
        C1570ms msVar = (C1570ms) object;
        return this.f4292uO.equals(msVar.f4292uO) && this.ahV == msVar.ahV;
    }

    public int hashCode() {
        return this.f4292uO.hashCode();
    }

    public String toString() {
        return this.f4292uO;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1571mt mtVar = CREATOR;
        C1571mt.m5634a(this, parcel, flags);
    }
}
