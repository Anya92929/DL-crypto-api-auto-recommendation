package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Parcelable.Creator {
    /* renamed from: a */
    static void m5671a(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, adOverlayInfoParcel.versionCode);
        zzb.zza(parcel, 2, (Parcelable) adOverlayInfoParcel.zzbtj, i, false);
        zzb.zza(parcel, 3, adOverlayInfoParcel.mo5395a(), false);
        zzb.zza(parcel, 4, adOverlayInfoParcel.mo5396b(), false);
        zzb.zza(parcel, 5, adOverlayInfoParcel.mo5397c(), false);
        zzb.zza(parcel, 6, adOverlayInfoParcel.mo5398d(), false);
        zzb.zza(parcel, 7, adOverlayInfoParcel.zzbto, false);
        zzb.zza(parcel, 8, adOverlayInfoParcel.zzbtp);
        zzb.zza(parcel, 9, adOverlayInfoParcel.zzbtq, false);
        zzb.zza(parcel, 10, adOverlayInfoParcel.mo5400f(), false);
        zzb.zzc(parcel, 11, adOverlayInfoParcel.orientation);
        zzb.zzc(parcel, 12, adOverlayInfoParcel.zzbts);
        zzb.zza(parcel, 13, adOverlayInfoParcel.url, false);
        zzb.zza(parcel, 14, (Parcelable) adOverlayInfoParcel.zzaow, i, false);
        zzb.zza(parcel, 15, adOverlayInfoParcel.mo5399e(), false);
        zzb.zza(parcel, 16, adOverlayInfoParcel.zzbtu, false);
        zzb.zza(parcel, 17, (Parcelable) adOverlayInfoParcel.zzbtv, i, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzag */
    public AdOverlayInfoParcel[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }

    /* renamed from: zzi */
    public AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) zza.zza(parcel, zzcl, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzr(parcel, zzcl);
                    break;
                case 4:
                    iBinder2 = zza.zzr(parcel, zzcl);
                    break;
                case 5:
                    iBinder3 = zza.zzr(parcel, zzcl);
                    break;
                case 6:
                    iBinder4 = zza.zzr(parcel, zzcl);
                    break;
                case 7:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 9:
                    str2 = zza.zzq(parcel, zzcl);
                    break;
                case 10:
                    iBinder5 = zza.zzr(parcel, zzcl);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 13:
                    str3 = zza.zzq(parcel, zzcl);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel, zzcl, VersionInfoParcel.CREATOR);
                    break;
                case 15:
                    iBinder6 = zza.zzr(parcel, zzcl);
                    break;
                case 16:
                    str4 = zza.zzq(parcel, zzcl);
                    break;
                case 17:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) zza.zza(parcel, zzcl, InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }
}
