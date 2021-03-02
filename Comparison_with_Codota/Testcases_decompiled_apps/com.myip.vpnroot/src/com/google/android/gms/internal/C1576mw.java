package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.mw */
public class C1576mw implements SafeParcelable {
    public static final C1577mx CREATOR = new C1577mx();

    /* renamed from: Dv */
    public final String f4295Dv;
    public final String ahY;
    public final String ahZ;
    public final int versionCode;

    public C1576mw(int i, String str, String str2, String str3) {
        this.versionCode = i;
        this.ahY = str;
        this.ahZ = str2;
        this.f4295Dv = str3;
    }

    public C1576mw(String str, Locale locale, String str2) {
        this.versionCode = 0;
        this.ahY = str;
        this.ahZ = locale.toString();
        this.f4295Dv = str2;
    }

    public int describeContents() {
        C1577mx mxVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof C1576mw)) {
            return false;
        }
        C1576mw mwVar = (C1576mw) object;
        return this.ahZ.equals(mwVar.ahZ) && this.ahY.equals(mwVar.ahY) && C0345m.equal(this.f4295Dv, mwVar.f4295Dv);
    }

    public int hashCode() {
        return C0345m.hashCode(this.ahY, this.ahZ, this.f4295Dv);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("clientPackageName", this.ahY).mo4549a("locale", this.ahZ).mo4549a("accountName", this.f4295Dv).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1577mx mxVar = CREATOR;
        C1577mx.m5644a(this, out, flags);
    }
}
