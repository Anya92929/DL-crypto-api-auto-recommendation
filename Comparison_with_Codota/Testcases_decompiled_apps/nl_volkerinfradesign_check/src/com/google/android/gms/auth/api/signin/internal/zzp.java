package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Parcelable.Creator<SignInConfiguration> {
    /* renamed from: a */
    static void m3633a(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, signInConfiguration.f2518a);
        zzb.zza(parcel, 2, signInConfiguration.zznk(), false);
        zzb.zza(parcel, 3, signInConfiguration.zzmR(), false);
        zzb.zza(parcel, 4, (Parcelable) signInConfiguration.zznl(), i, false);
        zzb.zza(parcel, 5, (Parcelable) signInConfiguration.zznm(), i, false);
        zzb.zza(parcel, 7, signInConfiguration.zznn(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzV */
    public SignInConfiguration createFromParcel(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        GoogleSignInOptions googleSignInOptions = null;
        EmailSignInOptions emailSignInOptions = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    emailSignInOptions = (EmailSignInOptions) zza.zza(parcel, zzat, EmailSignInOptions.CREATOR);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) zza.zza(parcel, zzat, GoogleSignInOptions.CREATOR);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SignInConfiguration(i, str3, str2, emailSignInOptions, googleSignInOptions, str);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaQ */
    public SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
