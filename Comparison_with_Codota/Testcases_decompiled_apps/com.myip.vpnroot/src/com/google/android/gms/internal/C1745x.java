package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@C1130ez
/* renamed from: com.google.android.gms.internal.x */
public final class C1745x implements SafeParcelable {
    public static final C1746y CREATOR = new C1746y();

    /* renamed from: lX */
    public final boolean f4409lX;

    /* renamed from: mh */
    public final boolean f4410mh;
    public final int versionCode;

    C1745x(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.f4409lX = z;
        this.f4410mh = z2;
    }

    public C1745x(boolean z, boolean z2) {
        this.versionCode = 1;
        this.f4409lX = z;
        this.f4410mh = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1746y.m6228a(this, out, flags);
    }
}
