package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.C1382jr;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.a */
public class C2200a implements Parcelable.Creator<CommonWalletObject> {
    /* renamed from: a */
    static void m7423a(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, commonWalletObject.getVersionCode());
        C0354b.m927a(parcel, 2, commonWalletObject.f4639fl, false);
        C0354b.m927a(parcel, 3, commonWalletObject.asP, false);
        C0354b.m927a(parcel, 4, commonWalletObject.name, false);
        C0354b.m927a(parcel, 5, commonWalletObject.asJ, false);
        C0354b.m927a(parcel, 6, commonWalletObject.asL, false);
        C0354b.m927a(parcel, 7, commonWalletObject.asM, false);
        C0354b.m927a(parcel, 8, commonWalletObject.asN, false);
        C0354b.m927a(parcel, 9, commonWalletObject.asO, false);
        C0354b.m939c(parcel, 10, commonWalletObject.state);
        C0354b.m940c(parcel, 11, commonWalletObject.asQ, false);
        C0354b.m923a(parcel, 12, (Parcelable) commonWalletObject.asR, i, false);
        C0354b.m940c(parcel, 13, commonWalletObject.asS, false);
        C0354b.m927a(parcel, 14, commonWalletObject.asT, false);
        C0354b.m927a(parcel, 15, commonWalletObject.asU, false);
        C0354b.m930a(parcel, 17, commonWalletObject.asW);
        C0354b.m940c(parcel, 16, commonWalletObject.asV, false);
        C0354b.m940c(parcel, 19, commonWalletObject.asY, false);
        C0354b.m940c(parcel, 18, commonWalletObject.asX, false);
        C0354b.m940c(parcel, 20, commonWalletObject.asZ, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dG */
    public CommonWalletObject createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        ArrayList<C2215p> hz = C1382jr.m5209hz();
        C2211l lVar = null;
        ArrayList hz2 = C1382jr.m5209hz();
        String str9 = null;
        String str10 = null;
        ArrayList<C2203d> hz3 = C1382jr.m5209hz();
        boolean z = false;
        ArrayList<C2213n> hz4 = C1382jr.m5209hz();
        ArrayList<C2209j> hz5 = C1382jr.m5209hz();
        ArrayList<C2213n> hz6 = C1382jr.m5209hz();
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    str6 = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    str7 = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    str8 = C0352a.m900o(parcel, B);
                    break;
                case 10:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 11:
                    hz = C0352a.m887c(parcel, B, C2215p.CREATOR);
                    break;
                case 12:
                    lVar = (C2211l) C0352a.m880a(parcel, B, C2211l.CREATOR);
                    break;
                case 13:
                    hz2 = C0352a.m887c(parcel, B, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = C0352a.m900o(parcel, B);
                    break;
                case 15:
                    str10 = C0352a.m900o(parcel, B);
                    break;
                case 16:
                    hz3 = C0352a.m887c(parcel, B, C2203d.CREATOR);
                    break;
                case 17:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 18:
                    hz4 = C0352a.m887c(parcel, B, C2213n.CREATOR);
                    break;
                case 19:
                    hz5 = C0352a.m887c(parcel, B, C2209j.CREATOR);
                    break;
                case FitnessActivities.BOXING:
                    hz6 = C0352a.m887c(parcel, B, C2213n.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, hz, lVar, hz2, str9, str10, hz3, z, hz4, hz5, hz6);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fI */
    public CommonWalletObject[] newArray(int i) {
        return new CommonWalletObject[i];
    }
}
