package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* renamed from: com.google.android.gms.internal.me */
public class C1556me implements SafeParcelable {
    public static final C1557mf CREATOR = new C1557mf();

    /* renamed from: BR */
    final int f4282BR;
    private final boolean afc;
    private final List<C1566mo> afd;

    C1556me(int i, boolean z, List<C1566mo> list) {
        this.f4282BR = i;
        this.afc = z;
        this.afd = list;
    }

    public int describeContents() {
        C1557mf mfVar = CREATOR;
        return 0;
    }

    /* renamed from: mc */
    public boolean mo9383mc() {
        return this.afc;
    }

    /* renamed from: md */
    public List<C1566mo> mo9384md() {
        return this.afd;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1557mf mfVar = CREATOR;
        C1557mf.m5600a(this, parcel, flags);
    }
}
