package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.Field;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.request.h */
public class C0664h implements Parcelable.Creator<DataTypeCreateRequest> {
    /* renamed from: a */
    static void m2022a(DataTypeCreateRequest dataTypeCreateRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, dataTypeCreateRequest.getName(), false);
        C0354b.m939c(parcel, 1000, dataTypeCreateRequest.getVersionCode());
        C0354b.m940c(parcel, 2, dataTypeCreateRequest.getFields(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bF */
    public DataTypeCreateRequest createFromParcel(Parcel parcel) {
        ArrayList<Field> arrayList = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    arrayList = C0352a.m887c(parcel, B, Field.CREATOR);
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
            return new DataTypeCreateRequest(i, str, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cW */
    public DataTypeCreateRequest[] newArray(int i) {
        return new DataTypeCreateRequest[i];
    }
}
