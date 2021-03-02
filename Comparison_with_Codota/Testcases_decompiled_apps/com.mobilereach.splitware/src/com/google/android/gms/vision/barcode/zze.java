package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Parcelable.Creator<Barcode.ContactInfo> {
    static void zza(Barcode.ContactInfo contactInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, contactInfo.versionCode);
        zzb.zza(parcel, 2, (Parcelable) contactInfo.name, i, false);
        zzb.zza(parcel, 3, contactInfo.organization, false);
        zzb.zza(parcel, 4, contactInfo.title, false);
        zzb.zza(parcel, 5, (T[]) contactInfo.phones, i, false);
        zzb.zza(parcel, 6, (T[]) contactInfo.emails, i, false);
        zzb.zza(parcel, 7, contactInfo.urls, false);
        zzb.zza(parcel, 8, (T[]) contactInfo.addresses, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzha */
    public Barcode.ContactInfo createFromParcel(Parcel parcel) {
        Barcode.Address[] addressArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String[] strArr = null;
        Barcode.Email[] emailArr = null;
        Barcode.Phone[] phoneArr = null;
        String str = null;
        String str2 = null;
        Barcode.PersonName personName = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    personName = (Barcode.PersonName) zza.zza(parcel, zzat, Barcode.PersonName.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    phoneArr = (Barcode.Phone[]) zza.zzb(parcel, zzat, Barcode.Phone.CREATOR);
                    break;
                case 6:
                    emailArr = (Barcode.Email[]) zza.zzb(parcel, zzat, Barcode.Email.CREATOR);
                    break;
                case 7:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                case 8:
                    addressArr = (Barcode.Address[]) zza.zzb(parcel, zzat, Barcode.Address.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Barcode.ContactInfo(i, personName, str2, str, phoneArr, emailArr, strArr, addressArr);
        }
        throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkx */
    public Barcode.ContactInfo[] newArray(int i) {
        return new Barcode.ContactInfo[i];
    }
}
