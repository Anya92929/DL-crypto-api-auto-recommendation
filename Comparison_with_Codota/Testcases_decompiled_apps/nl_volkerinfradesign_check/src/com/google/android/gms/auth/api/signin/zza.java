package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<EmailSignInOptions> {
    /* renamed from: a */
    static void m3642a(EmailSignInOptions emailSignInOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, emailSignInOptions.f2476a);
        zzb.zza(parcel, 2, (Parcelable) emailSignInOptions.zzmF(), i, false);
        zzb.zza(parcel, 3, emailSignInOptions.zzmH(), false);
        zzb.zza(parcel, 4, (Parcelable) emailSignInOptions.zzmG(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzQ */
    public EmailSignInOptions createFromParcel(Parcel parcel) {
        Uri uri;
        String str;
        Uri uri2;
        int i;
        Uri uri3 = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i2 = 0;
        String str2 = null;
        Uri uri4 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    Uri uri5 = uri3;
                    str = str2;
                    uri2 = uri4;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    uri = uri5;
                    break;
                case 2:
                    i = i2;
                    String str3 = str2;
                    uri2 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Uri.CREATOR);
                    uri = uri3;
                    str = str3;
                    break;
                case 3:
                    uri2 = uri4;
                    i = i2;
                    Uri uri6 = uri3;
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    uri = uri6;
                    break;
                case 4:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Uri.CREATOR);
                    str = str2;
                    uri2 = uri4;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    uri = uri3;
                    str = str2;
                    uri2 = uri4;
                    i = i2;
                    break;
            }
            i2 = i;
            uri4 = uri2;
            str2 = str;
            uri3 = uri;
        }
        if (parcel.dataPosition() == zzau) {
            return new EmailSignInOptions(i2, uri4, str2, uri3);
        }
        throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaL */
    public EmailSignInOptions[] newArray(int i) {
        return new EmailSignInOptions[i];
    }
}
