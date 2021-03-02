package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Parcelable.Creator<RecordConsentRequest> {
    /* renamed from: a */
    static void m4245a(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, recordConsentRequest.f3596a);
        zzb.zza(parcel, 2, (Parcelable) recordConsentRequest.getAccount(), i, false);
        zzb.zza(parcel, 3, (T[]) recordConsentRequest.zzFM(), i, false);
        zzb.zza(parcel, 4, recordConsentRequest.zzmR(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgT */
    public RecordConsentRequest createFromParcel(Parcel parcel) {
        String zzp;
        Scope[] scopeArr;
        Account account;
        int i;
        String str = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        Scope[] scopeArr2 = null;
        Account account2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    String str2 = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = zza.zzg(parcel, zzat);
                    zzp = str2;
                    break;
                case 2:
                    i = i2;
                    Scope[] scopeArr3 = scopeArr2;
                    account = (Account) zza.zza(parcel, zzat, Account.CREATOR);
                    zzp = str;
                    scopeArr = scopeArr3;
                    break;
                case 3:
                    account = account2;
                    i = i2;
                    String str3 = str;
                    scopeArr = (Scope[]) zza.zzb(parcel, zzat, Scope.CREATOR);
                    zzp = str3;
                    break;
                case 4:
                    zzp = zza.zzp(parcel, zzat);
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzp = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
            }
            i2 = i;
            account2 = account;
            scopeArr2 = scopeArr;
            str = zzp;
        }
        if (parcel.dataPosition() == zzau) {
            return new RecordConsentRequest(i2, account2, scopeArr2, str);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkb */
    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
