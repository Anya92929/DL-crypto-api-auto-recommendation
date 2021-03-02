package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<FaceSettingsParcel> {
    static void zza(FaceSettingsParcel faceSettingsParcel, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, faceSettingsParcel.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, faceSettingsParcel.mode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, faceSettingsParcel.zzbnV);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, faceSettingsParcel.zzbnW);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, faceSettingsParcel.zzbnX);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, faceSettingsParcel.zzbnY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, faceSettingsParcel.zzbnZ);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzhl */
    public FaceSettingsParcel createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        float f = -1.0f;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    f = zza.zzl(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FaceSettingsParcel(i4, i3, i2, i, z2, z, f);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkI */
    public FaceSettingsParcel[] newArray(int i) {
        return new FaceSettingsParcel[i];
    }
}
