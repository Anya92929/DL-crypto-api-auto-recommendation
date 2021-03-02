package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class ConnectionInfoCreator implements Parcelable.Creator<ConnectionInfo> {
    /* renamed from: a */
    static void m2262a(ConnectionInfo connectionInfo, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, connectionInfo.mo6588jU(), false);
        C0354b.m939c(parcel, 1000, connectionInfo.getVersionCode());
        C0354b.m939c(parcel, 2, connectionInfo.mo6589jV());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cf */
    public ConnectionInfo createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 1000:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ConnectionInfo(i2, str, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dA */
    public ConnectionInfo[] newArray(int i) {
        return new ConnectionInfo[i];
    }
}
