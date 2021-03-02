package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();

    /* renamed from: BR */
    private final int f1685BR;

    /* renamed from: Wf */
    private final String f1686Wf;

    /* renamed from: Wg */
    private final int f1687Wg;

    public ConnectionInfo(int versionCode, String clientAddress, int registrationLatency) {
        this.f1685BR = versionCode;
        this.f1686Wf = clientAddress;
        this.f1687Wg = registrationLatency;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f1685BR;
    }

    /* renamed from: jU */
    public String mo6588jU() {
        return this.f1686Wf;
    }

    /* renamed from: jV */
    public int mo6589jV() {
        return this.f1687Wg;
    }

    public void writeToParcel(Parcel out, int flags) {
        ConnectionInfoCreator.m2262a(this, out, flags);
    }
}
