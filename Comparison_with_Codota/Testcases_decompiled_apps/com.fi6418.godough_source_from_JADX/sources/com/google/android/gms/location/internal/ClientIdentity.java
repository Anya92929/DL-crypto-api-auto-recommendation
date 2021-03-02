package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ClientIdentity implements SafeParcelable {
    public static final C1123c CREATOR = new C1123c();

    /* renamed from: a */
    public final int f4939a;

    /* renamed from: b */
    public final String f4940b;

    /* renamed from: c */
    private final int f4941c;

    ClientIdentity(int i, int i2, String str) {
        this.f4941c = i;
        this.f4939a = i2;
        this.f4940b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7804a() {
        return this.f4941c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f4939a == this.f4939a && C1006bc.m4525a(clientIdentity.f4940b, this.f4940b);
    }

    public int hashCode() {
        return this.f4939a;
    }

    public String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.f4939a), this.f4940b});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1123c.m4876a(this, parcel, i);
    }
}
