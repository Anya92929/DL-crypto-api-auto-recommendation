package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.location.c */
public class C1757c implements SafeParcelable {
    public static final C1758d CREATOR = new C1758d();

    /* renamed from: BR */
    private final int f4423BR;
    int aem;
    int aen;
    long aeo;

    C1757c(int i, int i2, int i3, long j) {
        this.f4423BR = i;
        this.aem = i2;
        this.aen = i3;
        this.aeo = j;
    }

    /* renamed from: ed */
    private String m6253ed(int i) {
        switch (i) {
            case 0:
                return "STATUS_SUCCESSFUL";
            case 2:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case 3:
                return "STATUS_NO_INFO_IN_DATABASE";
            case 4:
                return "STATUS_INVALID_SCAN";
            case 5:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case 6:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case 7:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case 8:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C1757c)) {
            return false;
        }
        C1757c cVar = (C1757c) other;
        return this.aem == cVar.aem && this.aen == cVar.aen && this.aeo == cVar.aeo;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4423BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.aem), Integer.valueOf(this.aen), Long.valueOf(this.aeo));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocationStatus[cell status: ").append(m6253ed(this.aem));
        sb.append(", wifi status: ").append(m6253ed(this.aen));
        sb.append(", elapsed realtime ns: ").append(this.aeo);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1758d.m6254a(this, parcel, flags);
    }
}
