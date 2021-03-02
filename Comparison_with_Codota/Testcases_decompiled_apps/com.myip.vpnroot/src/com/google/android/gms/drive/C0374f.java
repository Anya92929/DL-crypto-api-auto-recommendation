package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.drive.f */
public class C0374f implements Parcelable.Creator<RealtimeDocumentSyncRequest> {
    /* renamed from: a */
    static void m1002a(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, realtimeDocumentSyncRequest.f839BR);
        C0354b.m938b(parcel, 2, realtimeDocumentSyncRequest.f840Nr, false);
        C0354b.m938b(parcel, 3, realtimeDocumentSyncRequest.f841Ns, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: Q */
    public RealtimeDocumentSyncRequest createFromParcel(Parcel parcel) {
        ArrayList<String> arrayList = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<String> arrayList2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    arrayList2 = C0352a.m876C(parcel, B);
                    break;
                case 3:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new RealtimeDocumentSyncRequest(i, arrayList2, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aX */
    public RealtimeDocumentSyncRequest[] newArray(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }
}
