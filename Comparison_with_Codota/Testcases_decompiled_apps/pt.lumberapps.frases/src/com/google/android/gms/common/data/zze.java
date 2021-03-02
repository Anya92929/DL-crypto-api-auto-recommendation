package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator {
    /* renamed from: a */
    static void m6001a(DataHolder dataHolder, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zza(parcel, 1, dataHolder.mo6428b(), false);
        zzb.zza(parcel, 2, (Parcelable[]) dataHolder.mo6429c(), i, false);
        zzb.zzc(parcel, 3, dataHolder.getStatusCode());
        zzb.zza(parcel, 4, dataHolder.zzarc(), false);
        zzb.zzc(parcel, 1000, dataHolder.mo6427a());
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzcc */
    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzcm = zza.zzcm(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    strArr = zza.zzac(parcel, zzcl);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) zza.zzb(parcel, zzcl, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 4:
                    bundle = zza.zzs(parcel, zzcl);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() != zzcm) {
            throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.zzarh();
        return dataHolder;
    }

    /* renamed from: zzfv */
    public DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
