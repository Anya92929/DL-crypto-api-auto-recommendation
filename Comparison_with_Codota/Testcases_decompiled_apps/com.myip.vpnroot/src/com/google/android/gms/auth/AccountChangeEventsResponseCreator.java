package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

public class AccountChangeEventsResponseCreator implements Parcelable.Creator<AccountChangeEventsResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m345a(AccountChangeEventsResponse accountChangeEventsResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, accountChangeEventsResponse.f365Di);
        C0354b.m940c(parcel, 2, accountChangeEventsResponse.f366me, false);
        C0354b.m915H(parcel, D);
    }

    public AccountChangeEventsResponse createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    arrayList = C0352a.m887c(parcel, B, AccountChangeEvent.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new AccountChangeEventsResponse(i, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public AccountChangeEventsResponse[] newArray(int size) {
        return new AccountChangeEventsResponse[size];
    }
}
