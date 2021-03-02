package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

/* renamed from: com.google.android.gms.wearable.internal.ah */
public class C2248ah implements SafeParcelable, MessageEvent {
    public static final Parcelable.Creator<C2248ah> CREATOR = new C2249ai();

    /* renamed from: BR */
    final int f4671BR;
    private final byte[] acw;
    private final String avw;
    private final String avx;

    /* renamed from: uQ */
    private final int f4672uQ;

    C2248ah(int i, int i2, String str, byte[] bArr, String str2) {
        this.f4671BR = i;
        this.f4672uQ = i2;
        this.avw = str;
        this.acw = bArr;
        this.avx = str2;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.acw;
    }

    public String getPath() {
        return this.avw;
    }

    public int getRequestId() {
        return this.f4672uQ;
    }

    public String getSourceNodeId() {
        return this.avx;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.f4672uQ + "," + this.avw + ", size=" + (this.acw == null ? "null" : Integer.valueOf(this.acw.length)) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2249ai.m7601a(this, dest, flags);
    }
}
