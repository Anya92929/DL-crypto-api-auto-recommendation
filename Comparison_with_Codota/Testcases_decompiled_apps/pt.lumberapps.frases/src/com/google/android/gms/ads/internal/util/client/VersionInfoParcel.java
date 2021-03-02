package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzin;

@zzin
public final class VersionInfoParcel extends AbstractSafeParcelable {
    public static final zzd CREATOR = new zzd();
    public final int versionCode;
    public int zzcnk;
    public int zzcnl;
    public boolean zzcnm;
    public String zzcs;

    public VersionInfoParcel(int i, int i2, boolean z) {
        this(i, i2, z, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VersionInfoParcel(int r7, int r8, boolean r9, boolean r10) {
        /*
            r6 = this;
            r1 = 1
            java.lang.String r0 = "afma-sdk-a-v"
            java.lang.String r2 = java.lang.String.valueOf(r0)
            if (r9 == 0) goto L_0x004b
            java.lang.String r0 = "0"
        L_0x000b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r4 = r4 + 24
            java.lang.String r5 = java.lang.String.valueOf(r0)
            int r5 = r5.length()
            int r4 = r4 + r5
            r3.<init>(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = "."
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = "."
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r2 = r0.toString()
            r0 = r6
            r3 = r7
            r4 = r8
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            return
        L_0x004b:
            if (r10 == 0) goto L_0x0050
            java.lang.String r0 = "2"
            goto L_0x000b
        L_0x0050:
            java.lang.String r0 = "1"
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.client.VersionInfoParcel.<init>(int, int, boolean, boolean):void");
    }

    VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        this.versionCode = i;
        this.zzcs = str;
        this.zzcnk = i2;
        this.zzcnl = i3;
        this.zzcnm = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.m5770a(this, parcel, i);
    }
}
