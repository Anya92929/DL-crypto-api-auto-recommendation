package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.c */
public class C2227c implements SafeParcelable {
    public static final Parcelable.Creator<C2227c> CREATOR = new C2228d();

    /* renamed from: BR */
    final int f4659BR;

    /* renamed from: FD */
    private final int f4660FD;

    /* renamed from: Ss */
    private final String f4661Ss;
    private final int auH;
    private final boolean auI;
    private boolean auJ;
    private String auK;
    private final String mName;

    C2227c(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, String str3) {
        this.f4659BR = i;
        this.mName = str;
        this.f4661Ss = str2;
        this.f4660FD = i2;
        this.auH = i3;
        this.auI = z;
        this.auJ = z2;
        this.auK = str3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C2227c)) {
            return false;
        }
        C2227c cVar = (C2227c) o;
        return C0345m.equal(Integer.valueOf(this.f4659BR), Integer.valueOf(cVar.f4659BR)) && C0345m.equal(this.mName, cVar.mName) && C0345m.equal(this.f4661Ss, cVar.f4661Ss) && C0345m.equal(Integer.valueOf(this.f4660FD), Integer.valueOf(cVar.f4660FD)) && C0345m.equal(Integer.valueOf(this.auH), Integer.valueOf(cVar.auH)) && C0345m.equal(Boolean.valueOf(this.auI), Boolean.valueOf(cVar.auI));
    }

    public String getAddress() {
        return this.f4661Ss;
    }

    public String getName() {
        return this.mName;
    }

    public int getRole() {
        return this.auH;
    }

    public int getType() {
        return this.f4660FD;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.f4659BR), this.mName, this.f4661Ss, Integer.valueOf(this.f4660FD), Integer.valueOf(this.auH), Boolean.valueOf(this.auI));
    }

    public boolean isConnected() {
        return this.auJ;
    }

    public boolean isEnabled() {
        return this.auI;
    }

    /* renamed from: pQ */
    public String mo12311pQ() {
        return this.auK;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConnectionConfiguration[ ");
        sb.append("mName=" + this.mName);
        sb.append(", mAddress=" + this.f4661Ss);
        sb.append(", mType=" + this.f4660FD);
        sb.append(", mRole=" + this.auH);
        sb.append(", mEnabled=" + this.auI);
        sb.append(", mIsConnected=" + this.auJ);
        sb.append(", mEnabled=" + this.auK);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2228d.m7484a(this, dest, flags);
    }
}
