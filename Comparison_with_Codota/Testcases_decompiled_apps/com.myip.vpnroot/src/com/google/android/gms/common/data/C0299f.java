package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.common.data.f */
public class C0299f implements Parcelable.Creator<DataHolder> {
    /* renamed from: a */
    static void m627a(DataHolder dataHolder, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m934a(parcel, 1, dataHolder.mo4316gC(), false);
        C0354b.m939c(parcel, 1000, dataHolder.getVersionCode());
        C0354b.m933a(parcel, 2, (T[]) dataHolder.mo4317gD(), i, false);
        C0354b.m939c(parcel, 3, dataHolder.getStatusCode());
        C0354b.m920a(parcel, 4, dataHolder.mo4321gz(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: at */
    public DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }

    /* renamed from: z */
    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int C = C0352a.m875C(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    strArr = C0352a.m872A(parcel, B);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) C0352a.m886b(parcel, B, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                case 1000:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() != C) {
            throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.mo4315gB();
        return dataHolder;
    }
}
