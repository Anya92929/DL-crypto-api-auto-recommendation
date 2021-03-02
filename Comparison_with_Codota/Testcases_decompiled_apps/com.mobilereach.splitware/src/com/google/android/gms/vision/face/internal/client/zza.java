package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<FaceParcel> {
    static void zza(FaceParcel faceParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, faceParcel.versionCode);
        zzb.zzc(parcel, 2, faceParcel.f17id);
        zzb.zza(parcel, 3, faceParcel.centerX);
        zzb.zza(parcel, 4, faceParcel.centerY);
        zzb.zza(parcel, 5, faceParcel.width);
        zzb.zza(parcel, 6, faceParcel.height);
        zzb.zza(parcel, 7, faceParcel.zzbnP);
        zzb.zza(parcel, 8, faceParcel.zzbnQ);
        zzb.zza(parcel, 9, (T[]) faceParcel.zzbnR, i, false);
        zzb.zza(parcel, 10, faceParcel.zzbnS);
        zzb.zza(parcel, 11, faceParcel.zzbnT);
        zzb.zza(parcel, 12, faceParcel.zzbnU);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzhk */
    public FaceParcel createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        LandmarkParcel[] landmarkParcelArr = null;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 3:
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzat);
                    break;
                case 4:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzat);
                    break;
                case 5:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzat);
                    break;
                case 6:
                    f4 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzat);
                    break;
                case 7:
                    f5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzat);
                    break;
                case 8:
                    f6 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzat);
                    break;
                case 9:
                    landmarkParcelArr = (LandmarkParcel[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat, LandmarkParcel.CREATOR);
                    break;
                case 10:
                    f7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzat);
                    break;
                case 11:
                    f8 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzat);
                    break;
                case 12:
                    f9 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FaceParcel(i, i2, f, f2, f3, f4, f5, f6, landmarkParcelArr, f7, f8, f9);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkH */
    public FaceParcel[] newArray(int i) {
        return new FaceParcel[i];
    }
}
