package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzd implements Parcelable.Creator {
    /* renamed from: a */
    static void m5942a(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, logEventParcelable.versionCode);
        zzb.zza(parcel, 2, (Parcelable) logEventParcelable.f4230qu, i, false);
        zzb.zza(parcel, 3, logEventParcelable.f4231qv, false);
        zzb.zza(parcel, 4, logEventParcelable.f4232qw, false);
        zzb.zza(parcel, 5, logEventParcelable.f4233qx, false);
        zzb.zza(parcel, 6, logEventParcelable.f4234qy, false);
        zzb.zza(parcel, 7, logEventParcelable.f4235qz, false);
        zzb.zza(parcel, 8, logEventParcelable.f4226qA);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzbx */
    public LogEventParcelable createFromParcel(Parcel parcel) {
        byte[][] bArr = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        boolean z = true;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[] bArr2 = null;
        PlayLoggerContext playLoggerContext = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    playLoggerContext = (PlayLoggerContext) zza.zza(parcel, zzcl, PlayLoggerContext.CREATOR);
                    break;
                case 3:
                    bArr2 = zza.zzt(parcel, zzcl);
                    break;
                case 4:
                    iArr2 = zza.zzw(parcel, zzcl);
                    break;
                case 5:
                    strArr = zza.zzac(parcel, zzcl);
                    break;
                case 6:
                    iArr = zza.zzw(parcel, zzcl);
                    break;
                case 7:
                    bArr = zza.zzu(parcel, zzcl);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new LogEventParcelable(i, playLoggerContext, bArr2, iArr2, strArr, iArr, bArr, z);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzfa */
    public LogEventParcelable[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
