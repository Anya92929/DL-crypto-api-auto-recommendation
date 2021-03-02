package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogEvent implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String tag;
    public final int versionCode;
    public final long zzbdA;
    public final long zzbdB;
    public final byte[] zzbdC;
    public final Bundle zzbdD;

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.zzbdA = j;
        this.zzbdB = j2;
        this.tag = str;
        this.zzbdC = bArr;
        this.zzbdD = bundle;
    }

    public LogEvent(long j, long j2, String str, byte[] bArr, String... strArr) {
        this.versionCode = 1;
        this.zzbdA = j;
        this.zzbdB = j2;
        this.tag = str;
        this.zzbdC = bArr;
        this.zzbdD = m4231a(strArr);
    }

    /* renamed from: a */
    private static Bundle m4231a(String... strArr) {
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
        sb.append("eventTime=").append(this.zzbdA).append(",");
        sb.append("eventUptime=").append(this.zzbdB).append(",");
        if (this.zzbdD != null && !this.zzbdD.isEmpty()) {
            sb.append("keyValues=");
            for (String str : this.zzbdD.keySet()) {
                sb.append("(").append(str).append(",");
                sb.append(this.zzbdD.getString(str)).append(")");
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m4233a(this, parcel, i);
    }
}
