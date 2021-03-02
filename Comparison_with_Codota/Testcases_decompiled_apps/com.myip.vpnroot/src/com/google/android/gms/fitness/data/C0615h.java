package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.data.h */
public class C0615h implements Parcelable.Creator<DataType> {
    /* renamed from: a */
    static void m1849a(DataType dataType, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, dataType.getName(), false);
        C0354b.m939c(parcel, 1000, dataType.getVersionCode());
        C0354b.m940c(parcel, 2, dataType.getFields(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bo */
    public DataType createFromParcel(Parcel parcel) {
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
            return new DataType(i, str, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cF */
    public DataType[] newArray(int i) {
        return new DataType[i];
    }
}
