package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzd implements Parcelable.Creator<LogEventParcelable> {
    /* renamed from: a */
    static void m3682a(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, logEventParcelable.versionCode);
        zzb.zza(parcel, 2, (Parcelable) logEventParcelable.zzafh, i, false);
        zzb.zza(parcel, 3, logEventParcelable.zzafi, false);
        zzb.zza(parcel, 4, logEventParcelable.zzafj, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaf */
    public LogEventParcelable createFromParcel(Parcel parcel) {
        int[] zzv;
        byte[] bArr;
        PlayLoggerContext playLoggerContext;
        int i;
        int[] iArr = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        byte[] bArr2 = null;
        PlayLoggerContext playLoggerContext2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    int[] iArr2 = iArr;
                    bArr = bArr2;
                    playLoggerContext = playLoggerContext2;
                    i = zza.zzg(parcel, zzat);
                    zzv = iArr2;
                    break;
                case 2:
                    i = i2;
                    byte[] bArr3 = bArr2;
                    playLoggerContext = (PlayLoggerContext) zza.zza(parcel, zzat, PlayLoggerContext.CREATOR);
                    zzv = iArr;
                    bArr = bArr3;
                    break;
                case 3:
                    playLoggerContext = playLoggerContext2;
                    i = i2;
                    int[] iArr3 = iArr;
                    bArr = zza.zzs(parcel, zzat);
                    zzv = iArr3;
                    break;
                case 4:
                    zzv = zza.zzv(parcel, zzat);
                    bArr = bArr2;
                    playLoggerContext = playLoggerContext2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzv = iArr;
                    bArr = bArr2;
                    playLoggerContext = playLoggerContext2;
                    i = i2;
                    break;
            }
            i2 = i;
            playLoggerContext2 = playLoggerContext;
            bArr2 = bArr;
            iArr = zzv;
        }
        if (parcel.dataPosition() == zzau) {
            return new LogEventParcelable(i2, playLoggerContext2, bArr2, iArr);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbs */
    public LogEventParcelable[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
