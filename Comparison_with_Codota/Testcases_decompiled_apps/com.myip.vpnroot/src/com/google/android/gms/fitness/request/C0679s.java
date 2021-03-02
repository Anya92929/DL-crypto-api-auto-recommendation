package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.request.s */
public class C0679s implements Parcelable.Creator<SessionReadRequest> {
    /* renamed from: a */
    static void m2055a(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, sessionReadRequest.mo5989ju(), false);
        C0354b.m939c(parcel, 1000, sessionReadRequest.getVersionCode());
        C0354b.m927a(parcel, 2, sessionReadRequest.getSessionId(), false);
        C0354b.m919a(parcel, 3, sessionReadRequest.getStartTimeMillis());
        C0354b.m919a(parcel, 4, sessionReadRequest.getEndTimeMillis());
        C0354b.m940c(parcel, 5, sessionReadRequest.getDataTypes(), false);
        C0354b.m940c(parcel, 6, sessionReadRequest.getDataSources(), false);
        C0354b.m930a(parcel, 7, sessionReadRequest.mo5990jv());
        C0354b.m930a(parcel, 8, sessionReadRequest.mo5988jg());
        C0354b.m938b(parcel, 9, sessionReadRequest.mo5991jw(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bL */
    public SessionReadRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        ArrayList<DataType> arrayList = null;
        ArrayList<DataSource> arrayList2 = null;
        boolean z = false;
        boolean z2 = false;
        ArrayList<String> arrayList3 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 5:
                    arrayList = C0352a.m887c(parcel, B, DataType.CREATOR);
                    break;
                case 6:
                    arrayList2 = C0352a.m887c(parcel, B, DataSource.CREATOR);
                    break;
                case 7:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 8:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 9:
                    arrayList3 = C0352a.m876C(parcel, B);
                    break;
                case 1000:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new SessionReadRequest(i, str, str2, j, j2, arrayList, arrayList2, z, z2, arrayList3);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dd */
    public SessionReadRequest[] newArray(int i) {
        return new SessionReadRequest[i];
    }
}
