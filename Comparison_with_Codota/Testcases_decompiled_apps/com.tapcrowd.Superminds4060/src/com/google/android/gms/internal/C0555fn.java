package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.fn */
public class C0555fn implements SafeParcelable {
    public static final C0557fp CREATOR = new C0557fp();

    /* renamed from: iM */
    private final int f1353iM;

    /* renamed from: it */
    private final String f1354it;

    /* renamed from: rA */
    private final String[] f1355rA;

    /* renamed from: rB */
    private final String f1356rB;

    /* renamed from: rC */
    private final String f1357rC;

    /* renamed from: rD */
    private final String f1358rD;

    /* renamed from: rE */
    private final String f1359rE;

    /* renamed from: ry */
    private final String[] f1360ry;

    /* renamed from: rz */
    private final String[] f1361rz;

    C0555fn(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5) {
        this.f1353iM = i;
        this.f1354it = str;
        this.f1360ry = strArr;
        this.f1361rz = strArr2;
        this.f1355rA = strArr3;
        this.f1356rB = str2;
        this.f1357rC = str3;
        this.f1358rD = str4;
        this.f1359rE = str5;
    }

    C0555fn(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5) {
        this.f1353iM = 1;
        this.f1354it = str;
        this.f1360ry = strArr;
        this.f1361rz = strArr2;
        this.f1355rA = strArr3;
        this.f1356rB = str2;
        this.f1357rC = str3;
        this.f1358rD = str4;
        this.f1359rE = str5;
    }

    /* renamed from: cZ */
    public String[] mo4851cZ() {
        return this.f1360ry;
    }

    /* renamed from: da */
    public String[] mo4852da() {
        return this.f1361rz;
    }

    /* renamed from: db */
    public String[] mo4853db() {
        return this.f1355rA;
    }

    /* renamed from: dc */
    public String mo4854dc() {
        return this.f1356rB;
    }

    /* renamed from: dd */
    public String mo4855dd() {
        return this.f1357rC;
    }

    /* renamed from: de */
    public String mo4856de() {
        return this.f1358rD;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: df */
    public String mo4858df() {
        return this.f1359rE;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0555fn)) {
            return false;
        }
        C0555fn fnVar = (C0555fn) obj;
        return this.f1353iM == fnVar.f1353iM && C0408dl.equal(this.f1354it, fnVar.f1354it) && C0408dl.equal(this.f1360ry, fnVar.f1360ry) && C0408dl.equal(this.f1361rz, fnVar.f1361rz) && C0408dl.equal(this.f1355rA, fnVar.f1355rA) && C0408dl.equal(this.f1356rB, fnVar.f1356rB) && C0408dl.equal(this.f1357rC, fnVar.f1357rC) && C0408dl.equal(this.f1358rD, fnVar.f1358rD) && C0408dl.equal(this.f1359rE, fnVar.f1359rE);
    }

    public String getAccountName() {
        return this.f1354it;
    }

    public int getVersionCode() {
        return this.f1353iM;
    }

    public int hashCode() {
        return C0408dl.hashCode(Integer.valueOf(this.f1353iM), this.f1354it, this.f1360ry, this.f1361rz, this.f1355rA, this.f1356rB, this.f1357rC, this.f1358rD, this.f1359rE);
    }

    public String toString() {
        return C0408dl.m938d(this).mo4388a("versionCode", Integer.valueOf(this.f1353iM)).mo4388a("accountName", this.f1354it).mo4388a("requestedScopes", this.f1360ry).mo4388a("visibleActivities", this.f1361rz).mo4388a("requiredFeatures", this.f1355rA).mo4388a("packageNameForAuth", this.f1356rB).mo4388a("callingPackageName", this.f1357rC).mo4388a("applicationName", this.f1358rD).mo4388a("clientId", this.f1359rE).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0557fp.m1673a(this, out, flags);
    }
}
