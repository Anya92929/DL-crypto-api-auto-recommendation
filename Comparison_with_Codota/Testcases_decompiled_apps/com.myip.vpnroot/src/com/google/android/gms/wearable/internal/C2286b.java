package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.C2237ae;

/* renamed from: com.google.android.gms.wearable.internal.b */
public class C2286b implements SafeParcelable {
    public static final Parcelable.Creator<C2286b> CREATOR = new C2287c();

    /* renamed from: BR */
    final int f4681BR;
    public final C2237ae auZ;
    public final IntentFilter[] ava;

    C2286b(int i, IBinder iBinder, IntentFilter[] intentFilterArr) {
        this.f4681BR = i;
        if (iBinder != null) {
            this.auZ = C2237ae.C2238a.m7538bS(iBinder);
        } else {
            this.auZ = null;
        }
        this.ava = intentFilterArr;
    }

    public C2286b(C2285ax axVar) {
        this.f4681BR = 1;
        this.auZ = axVar;
        this.ava = axVar.mo12459pZ();
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: pT */
    public IBinder mo12461pT() {
        if (this.auZ == null) {
            return null;
        }
        return this.auZ.asBinder();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2287c.m7688a(this, dest, flags);
    }
}
