package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class AccountChangeEventCreator implements Parcelable.Creator<AccountChangeEvent> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m343a(AccountChangeEvent accountChangeEvent, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, accountChangeEvent.f357Di);
        C0354b.m919a(parcel, 2, accountChangeEvent.f358Dj);
        C0354b.m927a(parcel, 3, accountChangeEvent.f356Dd, false);
        C0354b.m939c(parcel, 4, accountChangeEvent.f359Dk);
        C0354b.m939c(parcel, 5, accountChangeEvent.f360Dl);
        C0354b.m927a(parcel, 6, accountChangeEvent.f361Dm, false);
        C0354b.m915H(parcel, D);
    }

    public AccountChangeEvent createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        long j = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 6:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new AccountChangeEvent(i3, j, str2, i2, i, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public AccountChangeEvent[] newArray(int size) {
        return new AccountChangeEvent[size];
    }
}
