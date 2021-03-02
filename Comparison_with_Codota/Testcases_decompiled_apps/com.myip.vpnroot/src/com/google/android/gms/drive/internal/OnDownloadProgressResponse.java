package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new C0396aj();

    /* renamed from: BR */
    final int f931BR;

    /* renamed from: Ph */
    final long f932Ph;

    /* renamed from: Pi */
    final long f933Pi;

    OnDownloadProgressResponse(int versionCode, long bytesLoaded, long bytesExpected) {
        this.f931BR = versionCode;
        this.f932Ph = bytesLoaded;
        this.f933Pi = bytesExpected;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: if */
    public long mo4805if() {
        return this.f932Ph;
    }

    /* renamed from: ig */
    public long mo4806ig() {
        return this.f933Pi;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0396aj.m1143a(this, dest, flags);
    }
}
