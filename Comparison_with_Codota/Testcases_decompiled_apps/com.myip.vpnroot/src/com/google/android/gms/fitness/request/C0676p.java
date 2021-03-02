package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.C0618k;

/* renamed from: com.google.android.gms.fitness.request.p */
public class C0676p implements SafeParcelable {
    public static final Parcelable.Creator<C0676p> CREATOR = new C0677q();

    /* renamed from: BR */
    private final int f1546BR;

    /* renamed from: Up */
    private final C0618k f1547Up;
    private final PendingIntent mPendingIntent;

    C0676p(int i, IBinder iBinder, PendingIntent pendingIntent) {
        this.f1546BR = i;
        this.f1547Up = iBinder == null ? null : C0618k.C0619a.m1858an(iBinder);
        this.mPendingIntent = pendingIntent;
    }

    public C0676p(C0618k kVar, PendingIntent pendingIntent) {
        this.f1546BR = 2;
        this.f1547Up = kVar;
        this.mPendingIntent = pendingIntent;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1546BR;
    }

    /* renamed from: jl */
    public PendingIntent mo6147jl() {
        return this.mPendingIntent;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: jq */
    public IBinder mo6148jq() {
        if (this.f1547Up == null) {
            return null;
        }
        return this.f1547Up.asBinder();
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.f1547Up});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0677q.m2049a(this, parcel, flags);
    }
}
