package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.C0642a;
import com.google.android.gms.fitness.request.C0667k;

/* renamed from: com.google.android.gms.fitness.request.ac */
public class C0647ac implements SafeParcelable {
    public static final Parcelable.Creator<C0647ac> CREATOR = new C0648ad();

    /* renamed from: BR */
    private final int f1513BR;

    /* renamed from: UF */
    private final C0667k f1514UF;

    C0647ac(int i, IBinder iBinder) {
        this.f1513BR = i;
        this.f1514UF = C0667k.C0668a.m2029ay(iBinder);
    }

    public C0647ac(BleScanCallback bleScanCallback) {
        this.f1513BR = 1;
        this.f1514UF = C0642a.C0644a.m1972iV().mo6024b(bleScanCallback);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1513BR;
    }

    /* renamed from: jz */
    public IBinder mo6035jz() {
        return this.f1514UF.asBinder();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0648ad.m1982a(this, parcel, flags);
    }
}
