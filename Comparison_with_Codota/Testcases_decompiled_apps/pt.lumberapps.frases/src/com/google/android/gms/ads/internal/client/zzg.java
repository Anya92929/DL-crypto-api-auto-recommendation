package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg implements Parcelable.Creator {
    /* renamed from: a */
    static void m5600a(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, adRequestParcel.versionCode);
        zzb.zza(parcel, 2, adRequestParcel.zzatm);
        zzb.zza(parcel, 3, adRequestParcel.extras, false);
        zzb.zzc(parcel, 4, adRequestParcel.zzatn);
        zzb.zzb(parcel, 5, adRequestParcel.zzato, false);
        zzb.zza(parcel, 6, adRequestParcel.zzatp);
        zzb.zzc(parcel, 7, adRequestParcel.zzatq);
        zzb.zza(parcel, 8, adRequestParcel.zzatr);
        zzb.zza(parcel, 9, adRequestParcel.zzats, false);
        zzb.zza(parcel, 10, (Parcelable) adRequestParcel.zzatt, i, false);
        zzb.zza(parcel, 11, (Parcelable) adRequestParcel.zzatu, i, false);
        zzb.zza(parcel, 12, adRequestParcel.zzatv, false);
        zzb.zza(parcel, 13, adRequestParcel.zzatw, false);
        zzb.zza(parcel, 14, adRequestParcel.zzatx, false);
        zzb.zzb(parcel, 15, adRequestParcel.zzaty, false);
        zzb.zza(parcel, 16, adRequestParcel.zzatz, false);
        zzb.zza(parcel, 17, adRequestParcel.zzaua, false);
        zzb.zza(parcel, 18, adRequestParcel.zzaub);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzc */
    public AdRequestParcel createFromParcel(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        ArrayList arrayList = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList arrayList2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzcl);
                    break;
                case 3:
                    bundle = zza.zzs(parcel, zzcl);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 5:
                    arrayList = zza.zzae(parcel, zzcl);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 7:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 9:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) zza.zza(parcel, zzcl, SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) zza.zza(parcel, zzcl, Location.CREATOR);
                    break;
                case 12:
                    str2 = zza.zzq(parcel, zzcl);
                    break;
                case 13:
                    bundle2 = zza.zzs(parcel, zzcl);
                    break;
                case 14:
                    bundle3 = zza.zzs(parcel, zzcl);
                    break;
                case 15:
                    arrayList2 = zza.zzae(parcel, zzcl);
                    break;
                case 16:
                    str3 = zza.zzq(parcel, zzcl);
                    break;
                case 17:
                    str4 = zza.zzq(parcel, zzcl);
                    break;
                case 18:
                    z3 = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new AdRequestParcel(i, j, bundle, i2, arrayList, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, arrayList2, str3, str4, z3);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }

    /* renamed from: zzr */
    public AdRequestParcel[] newArray(int i) {
        return new AdRequestParcel[i];
    }
}
