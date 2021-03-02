package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1369ji;

/* renamed from: com.google.android.gms.internal.jd */
public class C1363jd implements SafeParcelable {
    public static final C1364je CREATOR = new C1364je();

    /* renamed from: BR */
    private final int f4103BR;

    /* renamed from: Mk */
    private final C1365jf f4104Mk;

    C1363jd(int i, C1365jf jfVar) {
        this.f4103BR = i;
        this.f4104Mk = jfVar;
    }

    private C1363jd(C1365jf jfVar) {
        this.f4103BR = 1;
        this.f4104Mk = jfVar;
    }

    /* renamed from: a */
    public static C1363jd m5102a(C1369ji.C1371b<?, ?> bVar) {
        if (bVar instanceof C1365jf) {
            return new C1363jd((C1365jf) bVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        C1364je jeVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4103BR;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ha */
    public C1365jf mo8990ha() {
        return this.f4104Mk;
    }

    /* renamed from: hb */
    public C1369ji.C1371b<?, ?> mo8991hb() {
        if (this.f4104Mk != null) {
            return this.f4104Mk;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public void writeToParcel(Parcel out, int flags) {
        C1364je jeVar = CREATOR;
        C1364je.m5105a(this, out, flags);
    }
}
