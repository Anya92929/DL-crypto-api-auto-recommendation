package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.nh */
public class C1603nh implements SafeParcelable {
    public static final C1607nj CREATOR = new C1607nj();
    public final long akw;
    public final byte[] akx;
    public final Bundle aky;
    public final String tag;
    public final int versionCode;

    C1603nh(int i, long j, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.akw = j;
        this.tag = str;
        this.akx = bArr;
        this.aky = bundle;
    }

    public C1603nh(long j, String str, byte[] bArr, String... strArr) {
        this.versionCode = 1;
        this.akw = j;
        this.tag = str;
        this.akx = bArr;
        this.aky = m5693f(strArr);
    }

    /* renamed from: f */
    private static Bundle m5693f(String... strArr) {
        Bundle bundle = null;
        if (strArr != null) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("extras must have an even number of elements");
            }
            int length = strArr.length / 2;
            if (length != 0) {
                bundle = new Bundle(length);
                for (int i = 0; i < length; i++) {
                    bundle.putString(strArr[i * 2], strArr[(i * 2) + 1]);
                }
            }
        }
        return bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tag=").append(this.tag).append(",");
        sb.append("eventTime=").append(this.akw).append(",");
        if (this.aky != null && !this.aky.isEmpty()) {
            sb.append("keyValues=");
            for (String str : this.aky.keySet()) {
                sb.append("(").append(str).append(",");
                sb.append(this.aky.getString(str)).append(")");
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1607nj.m5697a(this, out, flags);
    }
}
