package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.h */
public class C1966h implements SafeParcelable {
    public static final C1968j CREATOR = new C1968j();

    /* renamed from: BR */
    private final int f4509BR;

    /* renamed from: Dd */
    private final String f4510Dd;
    private final String[] als;
    private final String[] alt;
    private final String[] alu;
    private final String alv;
    private final String alw;
    private final String alx;
    private final String aly;
    private final PlusCommonExtras alz;

    C1966h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.f4509BR = i;
        this.f4510Dd = str;
        this.als = strArr;
        this.alt = strArr2;
        this.alu = strArr3;
        this.alv = str2;
        this.alw = str3;
        this.alx = str4;
        this.aly = str5;
        this.alz = plusCommonExtras;
    }

    public C1966h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.f4509BR = 1;
        this.f4510Dd = str;
        this.als = strArr;
        this.alt = strArr2;
        this.alu = strArr3;
        this.alv = str2;
        this.alw = str3;
        this.alx = str4;
        this.aly = null;
        this.alz = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1966h)) {
            return false;
        }
        C1966h hVar = (C1966h) obj;
        return this.f4509BR == hVar.f4509BR && C0345m.equal(this.f4510Dd, hVar.f4510Dd) && Arrays.equals(this.als, hVar.als) && Arrays.equals(this.alt, hVar.alt) && Arrays.equals(this.alu, hVar.alu) && C0345m.equal(this.alv, hVar.alv) && C0345m.equal(this.alw, hVar.alw) && C0345m.equal(this.alx, hVar.alx) && C0345m.equal(this.aly, hVar.aly) && C0345m.equal(this.alz, hVar.alz);
    }

    public String getAccountName() {
        return this.f4510Dd;
    }

    public int getVersionCode() {
        return this.f4509BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.f4509BR), this.f4510Dd, this.als, this.alt, this.alu, this.alv, this.alw, this.alx, this.aly, this.alz);
    }

    /* renamed from: ne */
    public String[] mo11382ne() {
        return this.als;
    }

    /* renamed from: nf */
    public String[] mo11383nf() {
        return this.alt;
    }

    /* renamed from: ng */
    public String[] mo11384ng() {
        return this.alu;
    }

    /* renamed from: nh */
    public String mo11385nh() {
        return this.alv;
    }

    /* renamed from: ni */
    public String mo11386ni() {
        return this.alw;
    }

    /* renamed from: nj */
    public String mo11387nj() {
        return this.alx;
    }

    /* renamed from: nk */
    public String mo11388nk() {
        return this.aly;
    }

    /* renamed from: nl */
    public PlusCommonExtras mo11389nl() {
        return this.alz;
    }

    /* renamed from: nm */
    public Bundle mo11390nm() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.alz.mo11310o(bundle);
        return bundle;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("versionCode", Integer.valueOf(this.f4509BR)).mo4549a("accountName", this.f4510Dd).mo4549a("requestedScopes", this.als).mo4549a("visibleActivities", this.alt).mo4549a("requiredFeatures", this.alu).mo4549a("packageNameForAuth", this.alv).mo4549a("callingPackageName", this.alw).mo4549a("applicationName", this.alx).mo4549a("extra", this.alz.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1968j.m6665a(this, out, flags);
    }
}
