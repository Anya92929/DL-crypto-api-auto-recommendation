package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.internal.aq */
public class C0403aq implements Parcelable.Creator<OnLoadRealtimeResponse> {
    /* renamed from: a */
    static void m1164a(OnLoadRealtimeResponse onLoadRealtimeResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, onLoadRealtimeResponse.f947BR);
        C0354b.m930a(parcel, 2, onLoadRealtimeResponse.f948vR);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: as */
    public OnLoadRealtimeResponse createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new OnLoadRealtimeResponse(i, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bE */
    public OnLoadRealtimeResponse[] newArray(int i) {
        return new OnLoadRealtimeResponse[i];
    }
}
