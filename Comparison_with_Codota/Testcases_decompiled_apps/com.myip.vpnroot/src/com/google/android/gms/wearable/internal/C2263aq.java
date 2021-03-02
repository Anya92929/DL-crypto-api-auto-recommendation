package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.C2237ae;

/* renamed from: com.google.android.gms.wearable.internal.aq */
public class C2263aq implements SafeParcelable {
    public static final Parcelable.Creator<C2263aq> CREATOR = new C2264ar();

    /* renamed from: BR */
    final int f4678BR;
    public final C2237ae auZ;

    C2263aq(int i, IBinder iBinder) {
        this.f4678BR = i;
        if (iBinder != null) {
            this.auZ = C2237ae.C2238a.m7538bS(iBinder);
        } else {
            this.auZ = null;
        }
    }

    public C2263aq(C2237ae aeVar) {
        this.f4678BR = 1;
        this.auZ = aeVar;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: pT */
    public IBinder mo12421pT() {
        if (this.auZ == null) {
            return null;
        }
        return this.auZ.asBinder();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2264ar.m7630a(this, dest, flags);
    }
}
