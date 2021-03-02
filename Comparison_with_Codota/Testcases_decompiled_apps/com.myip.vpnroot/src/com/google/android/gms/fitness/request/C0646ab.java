package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.request.ab */
public class C0646ab implements Parcelable.Creator<StartBleScanRequest> {
    /* renamed from: a */
    static void m1978a(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, startBleScanRequest.getDataTypes(), false);
        C0354b.m939c(parcel, 1000, startBleScanRequest.getVersionCode());
        C0354b.m921a(parcel, 2, startBleScanRequest.mo6008jz(), false);
        C0354b.m939c(parcel, 3, startBleScanRequest.mo6007jA());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bQ */
    public StartBleScanRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        ArrayList<DataType> arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList = C0352a.m887c(parcel, B, DataType.CREATOR);
                    break;
                case 2:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                case 3:
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
            return new StartBleScanRequest(i2, arrayList, iBinder, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: di */
    public StartBleScanRequest[] newArray(int i) {
        return new StartBleScanRequest[i];
    }
}
