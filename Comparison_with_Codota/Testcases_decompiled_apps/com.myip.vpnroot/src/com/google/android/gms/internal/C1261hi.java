package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1271hq;

/* renamed from: com.google.android.gms.internal.hi */
public class C1261hi implements SafeParcelable {
    public static final C1262hj CREATOR = new C1262hj();

    /* renamed from: Cc */
    public static final int f3847Cc = Integer.parseInt("-1");

    /* renamed from: Cd */
    private static final C1271hq f3848Cd = new C1271hq.C1272a("SsbContext").mo8757E(true).mo8760at("blob").mo8762fn();

    /* renamed from: BR */
    final int f3849BR;

    /* renamed from: Ce */
    public final String f3850Ce;

    /* renamed from: Cf */
    final C1271hq f3851Cf;

    /* renamed from: Cg */
    public final int f3852Cg;

    /* renamed from: Ch */
    public final byte[] f3853Ch;

    C1261hi(int i, String str, C1271hq hqVar, int i2, byte[] bArr) {
        C0348n.m859b(i2 == f3847Cc || C1270hp.m4782O(i2) != null, (Object) "Invalid section type " + i2);
        this.f3849BR = i;
        this.f3850Ce = str;
        this.f3851Cf = hqVar;
        this.f3852Cg = i2;
        this.f3853Ch = bArr;
        String fl = mo8730fl();
        if (fl != null) {
            throw new IllegalArgumentException(fl);
        }
    }

    public C1261hi(String str, C1271hq hqVar) {
        this(1, str, hqVar, f3847Cc, (byte[]) null);
    }

    public C1261hi(String str, C1271hq hqVar, String str2) {
        this(1, str, hqVar, C1270hp.m4783as(str2), (byte[]) null);
    }

    public C1261hi(byte[] bArr, C1271hq hqVar) {
        this(1, (String) null, hqVar, f3847Cc, bArr);
    }

    public int describeContents() {
        C1262hj hjVar = CREATOR;
        return 0;
    }

    /* renamed from: fl */
    public String mo8730fl() {
        if (this.f3852Cg != f3847Cc && C1270hp.m4782O(this.f3852Cg) == null) {
            return "Invalid section type " + this.f3852Cg;
        }
        if (this.f3850Ce == null || this.f3853Ch == null) {
            return null;
        }
        return "Both content and blobContent set";
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1262hj hjVar = CREATOR;
        C1262hj.m4770a(this, dest, flags);
    }
}
