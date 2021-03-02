package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1265hm;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ho */
public class C1269ho implements Parcelable.Creator<C1265hm.C1267b> {
    /* renamed from: a */
    static void m4779a(C1265hm.C1267b bVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, bVar.f3859BR);
        C0354b.m923a(parcel, 1, (Parcelable) bVar.f3860Ck, i, false);
        C0354b.m940c(parcel, 2, bVar.f3861Cl, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: N */
    public C1265hm.C1267b[] newArray(int i) {
        return new C1265hm.C1267b[i];
    }

    /* renamed from: q */
    public C1265hm.C1267b createFromParcel(Parcel parcel) {
        ArrayList c;
        Status status;
        int i;
        ArrayList arrayList = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) C0352a.m880a(parcel, B, Status.CREATOR);
                    c = arrayList;
                    status = status3;
                    break;
                case 2:
                    c = C0352a.m887c(parcel, B, C1274hs.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    ArrayList arrayList2 = arrayList;
                    status = status2;
                    i = C0352a.m892g(parcel, B);
                    c = arrayList2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    c = arrayList;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            arrayList = c;
        }
        if (parcel.dataPosition() == C) {
            return new C1265hm.C1267b(i2, status2, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
