package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public final int versionCode;
    public PlayLoggerContext zzafh;
    public byte[] zzafi;
    public int[] zzafj;
    public final zzsz.zzd zzafk;
    public final zzb.C0425zzb zzafl;
    public final zzb.C0425zzb zzafm;

    LogEventParcelable(int versionCode2, PlayLoggerContext playLoggerContext, byte[] logEventBytes, int[] testCodes) {
        this.versionCode = versionCode2;
        this.zzafh = playLoggerContext;
        this.zzafi = logEventBytes;
        this.zzafj = testCodes;
        this.zzafk = null;
        this.zzafl = null;
        this.zzafm = null;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzsz.zzd logEvent, zzb.C0425zzb extensionProducer, zzb.C0425zzb clientVisualElementsProducer, int[] testCodes) {
        this.versionCode = 1;
        this.zzafh = playLoggerContext;
        this.zzafk = logEvent;
        this.zzafl = extensionProducer;
        this.zzafm = clientVisualElementsProducer;
        this.zzafj = testCodes;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) other;
        return this.versionCode == logEventParcelable.versionCode && zzw.equal(this.zzafh, logEventParcelable.zzafh) && Arrays.equals(this.zzafi, logEventParcelable.zzafi) && Arrays.equals(this.zzafj, logEventParcelable.zzafj) && zzw.equal(this.zzafk, logEventParcelable.zzafk) && zzw.equal(this.zzafl, logEventParcelable.zzafl) && zzw.equal(this.zzafm, logEventParcelable.zzafm);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.zzafh, this.zzafi, this.zzafj, this.zzafk, this.zzafl, this.zzafm);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.versionCode);
        sb.append(", ");
        sb.append(this.zzafh);
        sb.append(", ");
        sb.append(this.zzafi == null ? null : new String(this.zzafi));
        sb.append(", ");
        sb.append(this.zzafj == null ? null : zzv.zzcL(", ").zza(Arrays.asList(new int[][]{this.zzafj})));
        sb.append(", ");
        sb.append(this.zzafk);
        sb.append(", ");
        sb.append(this.zzafl);
        sb.append(", ");
        sb.append(this.zzafm);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
