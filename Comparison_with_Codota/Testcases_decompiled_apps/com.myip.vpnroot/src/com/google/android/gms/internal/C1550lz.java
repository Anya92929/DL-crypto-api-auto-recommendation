package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.lz */
public class C1550lz implements SafeParcelable {
    public static final C1552ma CREATOR = new C1552ma();
    static final List<C1516lr> aeW = Collections.emptyList();

    /* renamed from: BR */
    private final int f4278BR;

    /* renamed from: Ux */
    LocationRequest f4279Ux;
    boolean aeX;
    boolean aeY;
    boolean aeZ;
    List<C1516lr> afa;
    final String mTag;

    C1550lz(int i, LocationRequest locationRequest, boolean z, boolean z2, boolean z3, List<C1516lr> list, String str) {
        this.f4278BR = i;
        this.f4279Ux = locationRequest;
        this.aeX = z;
        this.aeY = z2;
        this.aeZ = z3;
        this.afa = list;
        this.mTag = str;
    }

    private C1550lz(String str, LocationRequest locationRequest) {
        this(1, locationRequest, false, true, true, aeW, str);
    }

    /* renamed from: a */
    public static C1550lz m5576a(String str, LocationRequest locationRequest) {
        return new C1550lz(str, locationRequest);
    }

    /* renamed from: b */
    public static C1550lz m5577b(LocationRequest locationRequest) {
        return m5576a((String) null, locationRequest);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C1550lz)) {
            return false;
        }
        C1550lz lzVar = (C1550lz) other;
        return C0345m.equal(this.f4279Ux, lzVar.f4279Ux) && this.aeX == lzVar.aeX && this.aeY == lzVar.aeY && this.aeZ == lzVar.aeZ && C0345m.equal(this.afa, lzVar.afa);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4278BR;
    }

    public int hashCode() {
        return this.f4279Ux.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4279Ux.toString());
        sb.append(" requestNlpDebugInfo=");
        sb.append(this.aeX);
        sb.append(" restorePendingIntentListeners=");
        sb.append(this.aeY);
        sb.append(" triggerUpdate=");
        sb.append(this.aeZ);
        sb.append(" clients=");
        sb.append(this.afa);
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1552ma.m5580a(this, parcel, flags);
    }
}
