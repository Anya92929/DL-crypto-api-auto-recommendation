package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

/* renamed from: com.google.android.gms.wearable.internal.ak */
public class C2257ak implements SafeParcelable, Node {
    public static final Parcelable.Creator<C2257ak> CREATOR = new C2258al();

    /* renamed from: BL */
    private final String f4675BL;

    /* renamed from: BR */
    final int f4676BR;

    /* renamed from: Nz */
    private final String f4677Nz;

    C2257ak(int i, String str, String str2) {
        this.f4676BR = i;
        this.f4675BL = str;
        this.f4677Nz = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C2257ak)) {
            return false;
        }
        C2257ak akVar = (C2257ak) o;
        return akVar.f4675BL.equals(this.f4675BL) && akVar.f4677Nz.equals(this.f4677Nz);
    }

    public String getDisplayName() {
        return this.f4677Nz;
    }

    public String getId() {
        return this.f4675BL;
    }

    public int hashCode() {
        return ((this.f4675BL.hashCode() + 629) * 37) + this.f4677Nz.hashCode();
    }

    public String toString() {
        return "NodeParcelable{" + this.f4675BL + "," + this.f4677Nz + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2258al.m7620a(this, dest, flags);
    }
}
