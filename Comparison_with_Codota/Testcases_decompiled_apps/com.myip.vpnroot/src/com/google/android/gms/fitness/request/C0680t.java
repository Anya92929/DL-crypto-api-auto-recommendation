package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.fitness.request.t */
public class C0680t implements SafeParcelable {
    public static final Parcelable.Creator<C0680t> CREATOR = new C0681u();

    /* renamed from: BR */
    private final int f1548BR;
    private final PendingIntent mPendingIntent;

    C0680t(int i, PendingIntent pendingIntent) {
        this.f1548BR = i;
        this.mPendingIntent = pendingIntent;
    }

    public C0680t(PendingIntent pendingIntent) {
        this.f1548BR = 3;
        this.mPendingIntent = pendingIntent;
    }

    /* renamed from: a */
    private boolean m2058a(C0680t tVar) {
        return C0345m.equal(this.mPendingIntent, tVar.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof C0680t) && m2058a((C0680t) that));
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1548BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.mPendingIntent);
    }

    /* renamed from: jl */
    public PendingIntent mo6167jl() {
        return this.mPendingIntent;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0681u.m2060a(this, parcel, flags);
    }
}
