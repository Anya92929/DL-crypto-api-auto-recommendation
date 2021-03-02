package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p021v7.p023b.C0515k;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf implements Parcelable.Creator {
    /* renamed from: a */
    static void m5749a(AdRequestInfoParcel adRequestInfoParcel, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, adRequestInfoParcel.versionCode);
        zzb.zza(parcel, 2, adRequestInfoParcel.zzcaq, false);
        zzb.zza(parcel, 3, (Parcelable) adRequestInfoParcel.zzcar, i, false);
        zzb.zza(parcel, 4, (Parcelable) adRequestInfoParcel.zzapa, i, false);
        zzb.zza(parcel, 5, adRequestInfoParcel.zzaou, false);
        zzb.zza(parcel, 6, (Parcelable) adRequestInfoParcel.applicationInfo, i, false);
        zzb.zza(parcel, 7, (Parcelable) adRequestInfoParcel.zzcas, i, false);
        zzb.zza(parcel, 8, adRequestInfoParcel.zzcat, false);
        zzb.zza(parcel, 9, adRequestInfoParcel.zzcau, false);
        zzb.zza(parcel, 10, adRequestInfoParcel.zzcav, false);
        zzb.zza(parcel, 11, (Parcelable) adRequestInfoParcel.zzaow, i, false);
        zzb.zza(parcel, 12, adRequestInfoParcel.zzcaw, false);
        zzb.zzc(parcel, 13, adRequestInfoParcel.zzcax);
        zzb.zzb(parcel, 14, adRequestInfoParcel.zzaps, false);
        zzb.zza(parcel, 15, adRequestInfoParcel.zzcay, false);
        zzb.zza(parcel, 16, adRequestInfoParcel.zzcaz);
        zzb.zza(parcel, 17, (Parcelable) adRequestInfoParcel.zzcba, i, false);
        zzb.zzc(parcel, 18, adRequestInfoParcel.zzcbb);
        zzb.zzc(parcel, 19, adRequestInfoParcel.zzcbc);
        zzb.zza(parcel, 20, adRequestInfoParcel.zzcbd);
        zzb.zza(parcel, 21, adRequestInfoParcel.zzcbe, false);
        zzb.zza(parcel, 25, adRequestInfoParcel.zzcbf);
        zzb.zza(parcel, 26, adRequestInfoParcel.zzcbg, false);
        zzb.zzb(parcel, 27, adRequestInfoParcel.zzcbh, false);
        zzb.zza(parcel, 28, adRequestInfoParcel.zzaot, false);
        zzb.zza(parcel, 29, (Parcelable) adRequestInfoParcel.zzapo, i, false);
        zzb.zzb(parcel, 30, adRequestInfoParcel.zzcbi, false);
        zzb.zza(parcel, 31, adRequestInfoParcel.zzcbj);
        zzb.zza(parcel, 32, (Parcelable) adRequestInfoParcel.zzcbk, i, false);
        zzb.zza(parcel, 33, adRequestInfoParcel.zzcbl, false);
        zzb.zza(parcel, 34, adRequestInfoParcel.zzcbm);
        zzb.zzc(parcel, 35, adRequestInfoParcel.zzcbn);
        zzb.zzc(parcel, 36, adRequestInfoParcel.zzcbo);
        zzb.zza(parcel, 37, adRequestInfoParcel.zzcbp);
        zzb.zza(parcel, 38, adRequestInfoParcel.zzcbq);
        zzb.zza(parcel, 39, adRequestInfoParcel.zzcbr, false);
        zzb.zza(parcel, 40, adRequestInfoParcel.zzcbs);
        zzb.zza(parcel, 41, adRequestInfoParcel.zzcbt, false);
        zzb.zza(parcel, 42, adRequestInfoParcel.zzbnq);
        zzb.zzc(parcel, 43, adRequestInfoParcel.zzcbu);
        zzb.zza(parcel, 44, adRequestInfoParcel.zzcbv, false);
        zzb.zzaj(parcel, zzcn);
    }

    /* renamed from: zzao */
    public AdRequestInfoParcel[] newArray(int i) {
        return new AdRequestInfoParcel[i];
    }

    /* renamed from: zzk */
    public AdRequestInfoParcel createFromParcel(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        Bundle bundle = null;
        AdRequestParcel adRequestParcel = null;
        AdSizeParcel adSizeParcel = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundle2 = null;
        int i2 = 0;
        ArrayList arrayList = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        ArrayList arrayList2 = null;
        String str7 = null;
        NativeAdOptionsParcel nativeAdOptionsParcel = null;
        ArrayList arrayList3 = null;
        long j2 = 0;
        CapabilityParcel capabilityParcel = null;
        String str8 = null;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        int i7 = 0;
        Bundle bundle4 = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    bundle = zza.zzs(parcel, zzcl);
                    break;
                case 3:
                    adRequestParcel = (AdRequestParcel) zza.zza(parcel, zzcl, AdRequestParcel.CREATOR);
                    break;
                case 4:
                    adSizeParcel = (AdSizeParcel) zza.zza(parcel, zzcl, AdSizeParcel.CREATOR);
                    break;
                case 5:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) zza.zza(parcel, zzcl, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) zza.zza(parcel, zzcl, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = zza.zzq(parcel, zzcl);
                    break;
                case 9:
                    str3 = zza.zzq(parcel, zzcl);
                    break;
                case 10:
                    str4 = zza.zzq(parcel, zzcl);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel, zzcl, VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundle2 = zza.zzs(parcel, zzcl);
                    break;
                case 13:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 14:
                    arrayList = zza.zzae(parcel, zzcl);
                    break;
                case 15:
                    bundle3 = zza.zzs(parcel, zzcl);
                    break;
                case 16:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 17:
                    messenger = (Messenger) zza.zza(parcel, zzcl, Messenger.CREATOR);
                    break;
                case 18:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 19:
                    i4 = zza.zzg(parcel, zzcl);
                    break;
                case 20:
                    f = zza.zzl(parcel, zzcl);
                    break;
                case 21:
                    str5 = zza.zzq(parcel, zzcl);
                    break;
                case 25:
                    j = zza.zzi(parcel, zzcl);
                    break;
                case 26:
                    str6 = zza.zzq(parcel, zzcl);
                    break;
                case 27:
                    arrayList2 = zza.zzae(parcel, zzcl);
                    break;
                case 28:
                    str7 = zza.zzq(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeBackground:
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) zza.zza(parcel, zzcl, NativeAdOptionsParcel.CREATOR);
                    break;
                case C0515k.AppCompatTheme_actionModeSplitBackground:
                    arrayList3 = zza.zzae(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeCloseDrawable:
                    j2 = zza.zzi(parcel, zzcl);
                    break;
                case 32:
                    capabilityParcel = (CapabilityParcel) zza.zza(parcel, zzcl, CapabilityParcel.CREATOR);
                    break;
                case C0515k.AppCompatTheme_actionModeCopyDrawable:
                    str8 = zza.zzq(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModePasteDrawable:
                    f2 = zza.zzl(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeSelectAllDrawable:
                    i5 = zza.zzg(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeShareDrawable:
                    i6 = zza.zzg(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeFindDrawable:
                    z3 = zza.zzc(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModeWebSearchDrawable:
                    z4 = zza.zzc(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_actionModePopupWindowStyle:
                    str9 = zza.zzq(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_textAppearanceSmallPopupMenu:
                    str10 = zza.zzq(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                    z5 = zza.zzc(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_dialogTheme:
                    i7 = zza.zzg(parcel, zzcl);
                    break;
                case C0515k.AppCompatTheme_dialogPreferredPadding:
                    bundle4 = zza.zzs(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new AdRequestInfoParcel(i, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i2, arrayList, bundle3, z, messenger, i3, i4, f, str5, j, str6, arrayList2, str7, nativeAdOptionsParcel, arrayList3, j2, capabilityParcel, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4);
        }
        throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
    }
}
