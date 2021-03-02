package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.internal.ao */
public class C0401ao implements Parcelable.Creator<OnListParentsResponse> {
    /* renamed from: a */
    static void m1158a(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, onListParentsResponse.f945BR);
        C0354b.m923a(parcel, 2, (Parcelable) onListParentsResponse.f946Pn, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aq */
    public OnListParentsResponse createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    dataHolder = (DataHolder) C0352a.m880a(parcel, B, DataHolder.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bC */
    public OnListParentsResponse[] newArray(int i) {
        return new OnListParentsResponse[i];
    }
}
