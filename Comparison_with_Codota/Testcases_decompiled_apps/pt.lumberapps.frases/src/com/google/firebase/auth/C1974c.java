package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* renamed from: com.google.firebase.auth.c */
public class C1974c implements Parcelable.Creator {
    /* renamed from: a */
    static void m8075a(UserProfileChangeRequest userProfileChangeRequest, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, userProfileChangeRequest.f7475a);
        zzb.zza(parcel, 2, userProfileChangeRequest.mo9832a(), false);
        zzb.zza(parcel, 3, userProfileChangeRequest.mo9833b(), false);
        zzb.zza(parcel, 4, userProfileChangeRequest.mo9834c());
        zzb.zza(parcel, 5, userProfileChangeRequest.mo9835d());
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: a */
    public UserProfileChangeRequest createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        boolean z2 = false;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new UserProfileChangeRequest(i, str2, str, z2, z);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: a */
    public UserProfileChangeRequest[] newArray(int i) {
        return new UserProfileChangeRequest[i];
    }
}
