package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.C1382jr;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.C2203d;
import com.google.android.gms.wallet.wobs.C2205f;
import com.google.android.gms.wallet.wobs.C2209j;
import com.google.android.gms.wallet.wobs.C2211l;
import com.google.android.gms.wallet.wobs.C2213n;
import com.google.android.gms.wallet.wobs.C2215p;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.j */
public class C2192j implements Parcelable.Creator<LoyaltyWalletObject> {
    /* renamed from: a */
    static void m7402a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C0354b.m927a(parcel, 2, loyaltyWalletObject.f4621fl, false);
        C0354b.m927a(parcel, 3, loyaltyWalletObject.asI, false);
        C0354b.m927a(parcel, 4, loyaltyWalletObject.asJ, false);
        C0354b.m927a(parcel, 5, loyaltyWalletObject.asK, false);
        C0354b.m927a(parcel, 6, loyaltyWalletObject.f4620Dv, false);
        C0354b.m927a(parcel, 7, loyaltyWalletObject.asL, false);
        C0354b.m927a(parcel, 8, loyaltyWalletObject.asM, false);
        C0354b.m927a(parcel, 9, loyaltyWalletObject.asN, false);
        C0354b.m927a(parcel, 10, loyaltyWalletObject.asO, false);
        C0354b.m927a(parcel, 11, loyaltyWalletObject.asP, false);
        C0354b.m939c(parcel, 12, loyaltyWalletObject.state);
        C0354b.m940c(parcel, 13, loyaltyWalletObject.asQ, false);
        C0354b.m923a(parcel, 14, (Parcelable) loyaltyWalletObject.asR, i, false);
        C0354b.m940c(parcel, 15, loyaltyWalletObject.asS, false);
        C0354b.m927a(parcel, 17, loyaltyWalletObject.asU, false);
        C0354b.m927a(parcel, 16, loyaltyWalletObject.asT, false);
        C0354b.m930a(parcel, 19, loyaltyWalletObject.asW);
        C0354b.m940c(parcel, 18, loyaltyWalletObject.asV, false);
        C0354b.m940c(parcel, 21, loyaltyWalletObject.asY, false);
        C0354b.m940c(parcel, 20, loyaltyWalletObject.asX, false);
        C0354b.m923a(parcel, 23, (Parcelable) loyaltyWalletObject.ata, i, false);
        C0354b.m940c(parcel, 22, loyaltyWalletObject.asZ, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dv */
    public LoyaltyWalletObject createFromParcel(Parcel parcel) {
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
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList<C2215p> hz = C1382jr.m5209hz();
        C2211l lVar = null;
        ArrayList hz2 = C1382jr.m5209hz();
        String str11 = null;
        String str12 = null;
        ArrayList<C2203d> hz3 = C1382jr.m5209hz();
        boolean z = false;
        ArrayList<C2213n> hz4 = C1382jr.m5209hz();
        ArrayList<C2209j> hz5 = C1382jr.m5209hz();
        ArrayList<C2213n> hz6 = C1382jr.m5209hz();
        C2205f fVar = null;
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
                    str9 = C0352a.m900o(parcel, B);
                    break;
                case 11:
                    str10 = C0352a.m900o(parcel, B);
                    break;
                case 12:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 13:
                    hz = C0352a.m887c(parcel, B, C2215p.CREATOR);
                    break;
                case 14:
                    lVar = (C2211l) C0352a.m880a(parcel, B, C2211l.CREATOR);
                    break;
                case 15:
                    hz2 = C0352a.m887c(parcel, B, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = C0352a.m900o(parcel, B);
                    break;
                case 17:
                    str12 = C0352a.m900o(parcel, B);
                    break;
                case 18:
                    hz3 = C0352a.m887c(parcel, B, C2203d.CREATOR);
                    break;
                case 19:
                    z = C0352a.m888c(parcel, B);
                    break;
                case FitnessActivities.BOXING:
                    hz4 = C0352a.m887c(parcel, B, C2213n.CREATOR);
                    break;
                case 21:
                    hz5 = C0352a.m887c(parcel, B, C2209j.CREATOR);
                    break;
                case FitnessActivities.CIRCUIT_TRAINING:
                    hz6 = C0352a.m887c(parcel, B, C2213n.CREATOR);
                    break;
                case FitnessActivities.CRICKET:
                    fVar = (C2205f) C0352a.m880a(parcel, B, C2205f.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, hz, lVar, hz2, str11, str12, hz3, z, hz4, hz5, hz6, fVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fv */
    public LoyaltyWalletObject[] newArray(int i) {
        return new LoyaltyWalletObject[i];
    }
}
