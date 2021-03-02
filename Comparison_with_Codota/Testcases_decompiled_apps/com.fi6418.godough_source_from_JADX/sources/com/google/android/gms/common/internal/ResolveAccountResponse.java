package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountResponse implements SafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new C1011bh();

    /* renamed from: a */
    final int f4664a;

    /* renamed from: b */
    IBinder f4665b;

    /* renamed from: c */
    private ConnectionResult f4666c;

    /* renamed from: d */
    private boolean f4667d;

    /* renamed from: e */
    private boolean f4668e;

    public ResolveAccountResponse(int i) {
        this(new ConnectionResult(i, (PendingIntent) null));
    }

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f4664a = i;
        this.f4665b = iBinder;
        this.f4666c = connectionResult;
        this.f4667d = z;
        this.f4668e = z2;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, (IBinder) null, connectionResult, false, false);
    }

    /* renamed from: a */
    public C0993aq mo7484a() {
        return C0994ar.m4420a(this.f4665b);
    }

    /* renamed from: b */
    public ConnectionResult mo7485b() {
        return this.f4666c;
    }

    /* renamed from: c */
    public boolean mo7486c() {
        return this.f4667d;
    }

    /* renamed from: d */
    public boolean mo7487d() {
        return this.f4668e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f4666c.equals(resolveAccountResponse.f4666c) && mo7484a().equals(resolveAccountResponse.mo7484a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1011bh.m4542a(this, parcel, i);
    }
}
