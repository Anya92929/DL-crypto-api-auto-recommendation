package com.google.android.gms.plus;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0618r;

/* renamed from: com.google.android.gms.plus.a */
public class C0751a implements SafeParcelable {
    public static final C0752b CREATOR = new C0752b();

    /* renamed from: ab */
    private final int f1677ab;

    /* renamed from: g */
    private final String f1678g;

    /* renamed from: hY */
    private final String[] f1679hY;

    /* renamed from: hZ */
    private final String f1680hZ;

    /* renamed from: ia */
    private final String f1681ia;

    /* renamed from: ib */
    private final String f1682ib;

    /* renamed from: ik */
    private final String[] f1683ik;

    /* renamed from: il */
    private final String[] f1684il;

    public C0751a(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4) {
        this.f1677ab = i;
        this.f1678g = str;
        this.f1683ik = strArr;
        this.f1684il = strArr2;
        this.f1679hY = strArr3;
        this.f1680hZ = str2;
        this.f1681ia = str3;
        this.f1682ib = str4;
    }

    public C0751a(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4) {
        this.f1677ab = 1;
        this.f1678g = str;
        this.f1683ik = strArr;
        this.f1684il = strArr2;
        this.f1679hY = strArr3;
        this.f1680hZ = str2;
        this.f1681ia = str3;
        this.f1682ib = str4;
    }

    /* renamed from: bA */
    public String[] mo6361bA() {
        return this.f1679hY;
    }

    /* renamed from: bB */
    public String mo6362bB() {
        return this.f1680hZ;
    }

    /* renamed from: bC */
    public String mo6363bC() {
        return this.f1681ia;
    }

    /* renamed from: bD */
    public String mo6364bD() {
        return this.f1682ib;
    }

    /* renamed from: by */
    public String[] mo6365by() {
        return this.f1683ik;
    }

    /* renamed from: bz */
    public String[] mo6366bz() {
        return this.f1684il;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0751a)) {
            return false;
        }
        C0751a aVar = (C0751a) obj;
        return this.f1677ab == aVar.f1677ab && C0618r.m1881a(this.f1678g, aVar.f1678g) && C0618r.m1881a(this.f1683ik, aVar.f1683ik) && C0618r.m1881a(this.f1684il, aVar.f1684il) && C0618r.m1881a(this.f1679hY, aVar.f1679hY) && C0618r.m1881a(this.f1680hZ, aVar.f1680hZ) && C0618r.m1881a(this.f1681ia, aVar.f1681ia) && C0618r.m1881a(this.f1682ib, aVar.f1682ib);
    }

    public String getAccountName() {
        return this.f1678g;
    }

    public int hashCode() {
        return C0618r.hashCode(Integer.valueOf(this.f1677ab), this.f1678g, this.f1683ik, this.f1684il, this.f1679hY, this.f1680hZ, this.f1681ia, this.f1682ib);
    }

    /* renamed from: i */
    public int mo6371i() {
        return this.f1677ab;
    }

    public String toString() {
        return C0618r.m1882c(this).mo5486a("versionCode", Integer.valueOf(this.f1677ab)).mo5486a("accountName", this.f1678g).mo5486a("requestedScopes", this.f1683ik).mo5486a("visibleActivities", this.f1684il).mo5486a("requiredFeatures", this.f1679hY).mo5486a("packageNameForAuth", this.f1680hZ).mo5486a("callingPackageName", this.f1681ia).mo5486a("applicationName", this.f1682ib).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0752b.m2131a(this, out, flags);
    }
}
