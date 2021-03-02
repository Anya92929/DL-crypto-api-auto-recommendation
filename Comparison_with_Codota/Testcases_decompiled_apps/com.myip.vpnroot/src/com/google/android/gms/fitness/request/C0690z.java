package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.fitness.request.z */
public class C0690z implements SafeParcelable {
    public static final Parcelable.Creator<C0690z> CREATOR = new C0645aa();

    /* renamed from: BR */
    private final int f1555BR;
    private final PendingIntent mPendingIntent;

    C0690z(int i, PendingIntent pendingIntent) {
        this.f1555BR = i;
        this.mPendingIntent = pendingIntent;
    }

    public C0690z(PendingIntent pendingIntent) {
        this.f1555BR = 3;
        this.mPendingIntent = pendingIntent;
    }

    /* renamed from: a */
    private boolean m2079a(C0690z zVar) {
        return C0345m.equal(this.mPendingIntent, zVar.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof C0690z) && m2079a((C0690z) that));
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1555BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.mPendingIntent);
    }

    /* renamed from: jl */
    public PendingIntent mo6206jl() {
        return this.mPendingIntent;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0645aa.m1975a(this, parcel, flags);
    }
}
