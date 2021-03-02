package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.l */
public class C2194l implements Parcelable.Creator<MaskedWalletRequest> {
    /* renamed from: a */
    static void m7408a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0354b.m927a(parcel, 2, maskedWalletRequest.asr, false);
        C0354b.m930a(parcel, 3, maskedWalletRequest.ate);
        C0354b.m930a(parcel, 4, maskedWalletRequest.atf);
        C0354b.m930a(parcel, 5, maskedWalletRequest.atg);
        C0354b.m927a(parcel, 6, maskedWalletRequest.ath, false);
        C0354b.m927a(parcel, 7, maskedWalletRequest.asl, false);
        C0354b.m927a(parcel, 8, maskedWalletRequest.ati, false);
        C0354b.m923a(parcel, 9, (Parcelable) maskedWalletRequest.asA, i, false);
        C0354b.m930a(parcel, 10, maskedWalletRequest.atj);
        C0354b.m930a(parcel, 11, maskedWalletRequest.atk);
        C0354b.m933a(parcel, 12, (T[]) maskedWalletRequest.atl, i, false);
        C0354b.m930a(parcel, 13, maskedWalletRequest.atm);
        C0354b.m930a(parcel, 14, maskedWalletRequest.atn);
        C0354b.m940c(parcel, 15, maskedWalletRequest.ato, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dx */
    public MaskedWalletRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList<CountrySpecification> arrayList = null;
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
                    z = C0352a.m888c(parcel, B);
                    break;
                case 4:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 5:
                    z3 = C0352a.m888c(parcel, B);
                    break;
                case 6:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    cart = (Cart) C0352a.m880a(parcel, B, Cart.CREATOR);
                    break;
                case 10:
                    z4 = C0352a.m888c(parcel, B);
                    break;
                case 11:
                    z5 = C0352a.m888c(parcel, B);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) C0352a.m886b(parcel, B, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = C0352a.m888c(parcel, B);
                    break;
                case 14:
                    z7 = C0352a.m888c(parcel, B);
                    break;
                case 15:
                    arrayList = C0352a.m887c(parcel, B, CountrySpecification.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fx */
    public MaskedWalletRequest[] newArray(int i) {
        return new MaskedWalletRequest[i];
    }
}
