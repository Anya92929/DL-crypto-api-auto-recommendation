package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzi implements Parcelable.Creator {
    /* renamed from: a */
    static void m5751a(AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, autoClickProtectionConfigurationParcel.versionCode);
        zzb.zza(parcel, 2, autoClickProtectionConfigurationParcel.zzccu);
        zzb.zzb(parcel, 3, autoClickProtectionConfigurationParcel.zzccv, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzaq */
    public AutoClickProtectionConfigurationParcel[] newArray(int i) {
        return new AutoClickProtectionConfigurationParcel[i];
    }

    /* renamed from: zzm */
    public AutoClickProtectionConfigurationParcel createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 3:
                    arrayList = zza.zzae(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new AutoClickProtectionConfigurationParcel(i, z, arrayList);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }
}
