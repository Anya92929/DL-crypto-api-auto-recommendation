package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.nl */
public class C1609nl implements SafeParcelable {
    public static final C1610nm CREATOR = new C1610nm();
    public final int akG;
    public final int akH;
    public final String akI;
    public final String akJ;
    public final boolean akK;
    public final String packageName;
    public final int versionCode;

    public C1609nl(int i, String str, int i2, int i3, String str2, String str3, boolean z) {
        this.versionCode = i;
        this.packageName = str;
        this.akG = i2;
        this.akH = i3;
        this.akI = str2;
        this.akJ = str3;
        this.akK = z;
    }

    public C1609nl(String str, int i, int i2, String str2, String str3, boolean z) {
        this.versionCode = 1;
        this.packageName = (String) C0348n.m861i(str);
        this.akG = i;
        this.akH = i2;
        this.akI = str2;
        this.akJ = str3;
        this.akK = z;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof C1609nl)) {
            return false;
        }
        C1609nl nlVar = (C1609nl) object;
        return this.packageName.equals(nlVar.packageName) && this.akG == nlVar.akG && this.akH == nlVar.akH && C0345m.equal(this.akI, nlVar.akI) && C0345m.equal(this.akJ, nlVar.akJ) && this.akK == nlVar.akK;
    }

    public int hashCode() {
        return C0345m.hashCode(this.packageName, Integer.valueOf(this.akG), Integer.valueOf(this.akH), this.akI, this.akJ, Boolean.valueOf(this.akK));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayLoggerContext[");
        sb.append("package=").append(this.packageName).append(',');
        sb.append("versionCode=").append(this.versionCode).append(',');
        sb.append("logSource=").append(this.akH).append(',');
        sb.append("uploadAccount=").append(this.akI).append(',');
        sb.append("loggingId=").append(this.akJ).append(',');
        sb.append("logAndroidId=").append(this.akK);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1610nm.m5702a(this, out, flags);
    }
}
