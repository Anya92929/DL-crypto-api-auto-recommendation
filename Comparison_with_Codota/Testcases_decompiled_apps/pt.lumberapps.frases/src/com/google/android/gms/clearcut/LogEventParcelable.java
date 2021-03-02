package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzapz;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable extends AbstractSafeParcelable {
    public static final zzd CREATOR = new zzd();

    /* renamed from: qA */
    public boolean f4226qA;

    /* renamed from: qB */
    public final zzapz.zzd f4227qB;

    /* renamed from: qC */
    public final zzb.zzc f4228qC;

    /* renamed from: qD */
    public final zzb.zzc f4229qD;

    /* renamed from: qu */
    public PlayLoggerContext f4230qu;

    /* renamed from: qv */
    public byte[] f4231qv;

    /* renamed from: qw */
    public int[] f4232qw;

    /* renamed from: qx */
    public String[] f4233qx;

    /* renamed from: qy */
    public int[] f4234qy;

    /* renamed from: qz */
    public byte[][] f4235qz;
    public final int versionCode;

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z) {
        this.versionCode = i;
        this.f4230qu = playLoggerContext;
        this.f4231qv = bArr;
        this.f4232qw = iArr;
        this.f4233qx = strArr;
        this.f4227qB = null;
        this.f4228qC = null;
        this.f4229qD = null;
        this.f4234qy = iArr2;
        this.f4235qz = bArr2;
        this.f4226qA = z;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzapz.zzd zzd, zzb.zzc zzc, zzb.zzc zzc2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, boolean z) {
        this.versionCode = 1;
        this.f4230qu = playLoggerContext;
        this.f4227qB = zzd;
        this.f4228qC = zzc;
        this.f4229qD = zzc2;
        this.f4232qw = iArr;
        this.f4233qx = strArr;
        this.f4234qy = iArr2;
        this.f4235qz = bArr;
        this.f4226qA = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.versionCode == logEventParcelable.versionCode && zzaa.equal(this.f4230qu, logEventParcelable.f4230qu) && Arrays.equals(this.f4231qv, logEventParcelable.f4231qv) && Arrays.equals(this.f4232qw, logEventParcelable.f4232qw) && Arrays.equals(this.f4233qx, logEventParcelable.f4233qx) && zzaa.equal(this.f4227qB, logEventParcelable.f4227qB) && zzaa.equal(this.f4228qC, logEventParcelable.f4228qC) && zzaa.equal(this.f4229qD, logEventParcelable.f4229qD) && Arrays.equals(this.f4234qy, logEventParcelable.f4234qy) && Arrays.deepEquals(this.f4235qz, logEventParcelable.f4235qz) && this.f4226qA == logEventParcelable.f4226qA;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.versionCode), this.f4230qu, this.f4231qv, this.f4232qw, this.f4233qx, this.f4227qB, this.f4228qC, this.f4229qD, this.f4234qy, this.f4235qz, Boolean.valueOf(this.f4226qA));
    }

    public String toString() {
        return "LogEventParcelable[" + this.versionCode + ", " + this.f4230qu + ", " + "LogEventBytes: " + (this.f4231qv == null ? null : new String(this.f4231qv)) + ", " + "TestCodes: " + Arrays.toString(this.f4232qw) + ", " + "MendelPackages: " + Arrays.toString(this.f4233qx) + ", " + "LogEvent: " + this.f4227qB + ", " + "ExtensionProducer: " + this.f4228qC + ", " + "VeProducer: " + this.f4229qD + ", " + "ExperimentIDs: " + Arrays.toString(this.f4234qy) + ", " + "ExperimentTokens: " + Arrays.toString(this.f4235qz) + ", " + "AddPhenotypeExperimentTokens: " + this.f4226qA + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.m5942a(this, parcel, i);
    }
}
