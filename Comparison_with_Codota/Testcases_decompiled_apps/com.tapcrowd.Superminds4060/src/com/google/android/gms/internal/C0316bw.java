package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.bw */
public final class C0316bw implements SafeParcelable {
    public static final C0317bx CREATOR = new C0317bx();

    /* renamed from: eW */
    public final List<String> f926eW;

    /* renamed from: eX */
    public final List<String> f927eX;
    public final int errorCode;

    /* renamed from: fW */
    public final String f928fW;

    /* renamed from: fa */
    public final long f929fa;

    /* renamed from: gG */
    public final String f930gG;

    /* renamed from: gH */
    public final long f931gH;

    /* renamed from: gI */
    public final boolean f932gI;

    /* renamed from: gJ */
    public final long f933gJ;

    /* renamed from: gK */
    public final List<String> f934gK;
    public final int orientation;
    public final int versionCode;

    public C0316bw(int i) {
        this(1, (String) null, (String) null, (List<String>) null, i, (List<String>) null, -1, false, -1, (List<String>) null, -1, -1);
    }

    C0316bw(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3) {
        this.versionCode = i;
        this.f928fW = str;
        this.f930gG = str2;
        this.f926eW = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.f927eX = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f931gH = j;
        this.f932gI = z;
        this.f933gJ = j2;
        this.f934gK = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.f929fa = j3;
        this.orientation = i3;
    }

    public C0316bw(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i) {
        this(1, str, str2, list, -2, list2, j, z, j2, list3, j3, i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0317bx.m647a(this, out, flags);
    }
}
