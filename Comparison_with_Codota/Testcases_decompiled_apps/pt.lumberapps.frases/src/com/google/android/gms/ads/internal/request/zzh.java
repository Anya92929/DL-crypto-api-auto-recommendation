package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p021v7.p023b.C0515k;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh implements Parcelable.Creator {
    /* renamed from: a */
    static void m5750a(AdResponseParcel adResponseParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, adResponseParcel.versionCode);
        zzb.zza(parcel, 2, adResponseParcel.zzbto, false);
        zzb.zza(parcel, 3, adResponseParcel.body, false);
        zzb.zzb(parcel, 4, adResponseParcel.zzbnm, false);
        zzb.zzc(parcel, 5, adResponseParcel.errorCode);
        zzb.zzb(parcel, 6, adResponseParcel.zzbnn, false);
        zzb.zza(parcel, 7, adResponseParcel.zzcbx);
        zzb.zza(parcel, 8, adResponseParcel.zzcby);
        zzb.zza(parcel, 9, adResponseParcel.zzcbz);
        zzb.zzb(parcel, 10, adResponseParcel.zzcca, false);
        zzb.zza(parcel, 11, adResponseParcel.zzbns);
        zzb.zzc(parcel, 12, adResponseParcel.orientation);
        zzb.zza(parcel, 13, adResponseParcel.zzccb, false);
        zzb.zza(parcel, 14, adResponseParcel.zzccc);
        zzb.zza(parcel, 15, adResponseParcel.zzccd, false);
        zzb.zza(parcel, 18, adResponseParcel.zzcce);
        zzb.zza(parcel, 19, adResponseParcel.zzccf, false);
        zzb.zza(parcel, 21, adResponseParcel.zzccg, false);
        zzb.zza(parcel, 22, adResponseParcel.zzcch);
        zzb.zza(parcel, 23, adResponseParcel.zzauu);
        zzb.zza(parcel, 24, adResponseParcel.zzcaz);
        zzb.zza(parcel, 25, adResponseParcel.zzcci);
        zzb.zza(parcel, 26, adResponseParcel.zzccj);
        zzb.zza(parcel, 28, (Parcelable) adResponseParcel.zzcck, i, false);
        zzb.zza(parcel, 29, adResponseParcel.zzccl, false);
        zzb.zza(parcel, 30, adResponseParcel.zzccm, false);
        zzb.zza(parcel, 31, adResponseParcel.zzauv);
        zzb.zza(parcel, 32, adResponseParcel.zzauw);
        zzb.zza(parcel, 33, (Parcelable) adResponseParcel.zzccn, i, false);
        zzb.zzb(parcel, 34, adResponseParcel.zzcco, false);
        zzb.zzb(parcel, 35, adResponseParcel.zzccp, false);
        zzb.zza(parcel, 36, adResponseParcel.zzccq);
        zzb.zza(parcel, 37, (Parcelable) adResponseParcel.zzccr, i, false);
        zzb.zza(parcel, 38, adResponseParcel.zzcbq);
        zzb.zza(parcel, 39, adResponseParcel.zzcbr, false);
        zzb.zzb(parcel, 40, adResponseParcel.zzbnp, false);
        zzb.zza(parcel, 41, adResponseParcel.zzccs, false);
        zzb.zza(parcel, 42, adResponseParcel.zzbnq);
        zzb.zza(parcel, 43, adResponseParcel.zzcct, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzap */
    public AdResponseParcel[] newArray(int i) {
        return new AdResponseParcel[i];
    }

    /* renamed from: zzl */
    public AdResponseParcel createFromParcel(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        int i2 = 0;
        ArrayList arrayList2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        ArrayList arrayList3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        LargeParcelTeleporter largeParcelTeleporter = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        boolean z9 = false;
        RewardItemParcel rewardItemParcel = null;
        ArrayList arrayList4 = null;
        ArrayList arrayList5 = null;
        boolean z10 = false;
        AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel = null;
        boolean z11 = false;
        String str9 = null;
        ArrayList arrayList6 = null;
        String str10 = null;
        boolean z12 = false;
        String str11 = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzcl);
                    break;
                case 4:
                    arrayList = zza.zzae(parcel, zzcl);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 6:
                    arrayList2 = zza.zzae(parcel, zzcl);
                    break;
                case 7:
                    j = zza.zzi(parcel, zzcl);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 9:
                    j2 = zza.zzi(parcel, zzcl);
                    break;
                case 10:
                    arrayList3 = zza.zzae(parcel, zzcl);
                    break;
                case 11:
                    j3 = zza.zzi(parcel, zzcl);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 13:
                    str3 = zza.zzq(parcel, zzcl);
                    break;
                case 14:
                    j4 = zza.zzi(parcel, zzcl);
                    break;
                case 15:
                    str4 = zza.zzq(parcel, zzcl);
                    break;
                case 18:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 19:
                    str5 = zza.zzq(parcel, zzcl);
                    break;
                case 21:
                    str6 = zza.zzq(parcel, zzcl);
                    break;
                case 22:
                    z3 = zza.zzc(parcel, zzcl);
                    break;
                case 23:
                    z4 = zza.zzc(parcel, zzcl);
                    break;
                case 24:
                    z5 = zza.zzc(parcel, zzcl);
                    break;
                case 25:
                    z6 = zza.zzc(parcel, zzcl);
                    break;
                case 26:
                    z7 = zza.zzc(parcel, zzcl);
                    break;
                case 28:
                    largeParcelTeleporter = (LargeParcelTeleporter) zza.zza(parcel, zzcl, LargeParcelTeleporter.CREATOR);
                    break;
                case C0515k.AppCompatTheme_actionModeBackground:
                    str7 = zza.zzq(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeSplitBackground:
                    str8 = zza.zzq(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeCloseDrawable:
                    z8 = zza.zzc(parcel, zzcl);
                    break;
                case 32:
                    z9 = zza.zzc(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeCopyDrawable:
                    rewardItemParcel = (RewardItemParcel) zza.zza(parcel, zzcl, RewardItemParcel.CREATOR);
                    break;
                case C0515k.AppCompatTheme_actionModePasteDrawable:
                    arrayList4 = zza.zzae(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeSelectAllDrawable:
                    arrayList5 = zza.zzae(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeShareDrawable:
                    z10 = zza.zzc(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeFindDrawable:
                    autoClickProtectionConfigurationParcel = (AutoClickProtectionConfigurationParcel) zza.zza(parcel, zzcl, AutoClickProtectionConfigurationParcel.CREATOR);
                    break;
                case C0515k.AppCompatTheme_actionModeWebSearchDrawable:
                    z11 = zza.zzc(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModePopupWindowStyle:
                    str9 = zza.zzq(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                    arrayList6 = zza.zzae(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_textAppearanceSmallPopupMenu:
                    str10 = zza.zzq(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                    z12 = zza.zzc(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_dialogTheme:
                    str11 = zza.zzq(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new AdResponseParcel(i, str, str2, arrayList, i2, arrayList2, j, z, j2, arrayList3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, largeParcelTeleporter, str7, str8, z8, z9, rewardItemParcel, arrayList4, arrayList5, z10, autoClickProtectionConfigurationParcel, z11, str9, arrayList6, str10, z12, str11);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }
}
