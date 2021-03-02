package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<ScopeDetail> {
    /* renamed from: a */
    static void m3648a(ScopeDetail scopeDetail, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, scopeDetail.f2546a);
        zzb.zza(parcel, 2, scopeDetail.f2547b, false);
        zzb.zza(parcel, 3, scopeDetail.f2548c, false);
        zzb.zza(parcel, 4, scopeDetail.f2549d, false);
        zzb.zza(parcel, 5, scopeDetail.f2550e, false);
        zzb.zza(parcel, 6, scopeDetail.f2551f, false);
        zzb.zzb(parcel, 7, scopeDetail.f2552g, false);
        zzb.zza(parcel, 8, (Parcelable) scopeDetail.zzYB, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzY */
    public ScopeDetail createFromParcel(Parcel parcel) {
        FACLData fACLData = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    arrayList = zza.zzD(parcel, zzat);
                    break;
                case 8:
                    fACLData = (FACLData) zza.zza(parcel, zzat, FACLData.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ScopeDetail(i, str5, str4, str3, str2, str, arrayList, fACLData);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaV */
    public ScopeDetail[] newArray(int i) {
        return new ScopeDetail[i];
    }
}
