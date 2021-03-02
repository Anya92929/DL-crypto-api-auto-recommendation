package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

public class PlayLoggerContext extends AbstractSafeParcelable {
    public static final zza CREATOR = new zza();
    public final int arq;
    public final int arr;
    public final String ars;
    public final String art;
    public final boolean aru;
    public final String arv;
    public final boolean arw;
    public final int arx;
    public final String packageName;
    public final int versionCode;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.versionCode = i;
        this.packageName = str;
        this.arq = i2;
        this.arr = i3;
        this.ars = str2;
        this.art = str3;
        this.aru = z;
        this.arv = str4;
        this.arw = z2;
        this.arx = i4;
    }

    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.versionCode = 1;
        this.packageName = (String) zzab.zzy(str);
        this.arq = i;
        this.arr = i2;
        this.arv = str2;
        this.ars = str3;
        this.art = str4;
        this.aru = !z;
        this.arw = z;
        this.arx = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.arq == playLoggerContext.arq && this.arr == playLoggerContext.arr && zzaa.equal(this.arv, playLoggerContext.arv) && zzaa.equal(this.ars, playLoggerContext.ars) && zzaa.equal(this.art, playLoggerContext.art) && this.aru == playLoggerContext.aru && this.arw == playLoggerContext.arw && this.arx == playLoggerContext.arx;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.arq), Integer.valueOf(this.arr), this.arv, this.ars, this.art, Boolean.valueOf(this.aru), Boolean.valueOf(this.arw), Integer.valueOf(this.arx));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayLoggerContext[");
        sb.append("versionCode=").append(this.versionCode).append(',');
        sb.append("package=").append(this.packageName).append(',');
        sb.append("packageVersionCode=").append(this.arq).append(',');
        sb.append("logSource=").append(this.arr).append(',');
        sb.append("logSourceName=").append(this.arv).append(',');
        sb.append("uploadAccount=").append(this.ars).append(',');
        sb.append("loggingId=").append(this.art).append(',');
        sb.append("logAndroidId=").append(this.aru).append(',');
        sb.append("isAnonymous=").append(this.arw).append(',');
        sb.append("qosTier=").append(this.arx);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m8021a(this, parcel, i);
    }
}
