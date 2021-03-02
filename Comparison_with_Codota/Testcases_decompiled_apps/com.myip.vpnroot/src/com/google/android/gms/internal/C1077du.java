package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.du */
public class C1077du implements Parcelable.Creator<C1078dv> {
    /* renamed from: a */
    static void m4285a(C1078dv dvVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, dvVar.versionCode);
        C0354b.m921a(parcel, 2, dvVar.mo8373cl(), false);
        C0354b.m921a(parcel, 3, dvVar.mo8374cm(), false);
        C0354b.m921a(parcel, 4, dvVar.mo8375cn(), false);
        C0354b.m921a(parcel, 5, dvVar.mo8376co(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: g */
    public C1078dv createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    iBinder4 = C0352a.m901p(parcel, B);
                    break;
                case 3:
                    iBinder3 = C0352a.m901p(parcel, B);
                    break;
                case 4:
                    iBinder2 = C0352a.m901p(parcel, B);
                    break;
                case 5:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1078dv(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: n */
    public C1078dv[] newArray(int i) {
        return new C1078dv[i];
    }
}
