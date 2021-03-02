package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.internal.an */
public class C0400an implements Parcelable.Creator<OnListEntriesResponse> {
    /* renamed from: a */
    static void m1155a(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, onListEntriesResponse.f942BR);
        C0354b.m923a(parcel, 2, (Parcelable) onListEntriesResponse.f944Pm, i, false);
        C0354b.m930a(parcel, 3, onListEntriesResponse.f943Or);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ap */
    public OnListEntriesResponse createFromParcel(Parcel parcel) {
        boolean c;
        DataHolder dataHolder;
        int i;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        DataHolder dataHolder2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    boolean z2 = z;
                    dataHolder = dataHolder2;
                    i = C0352a.m892g(parcel, B);
                    c = z2;
                    break;
                case 2:
                    i = i2;
                    DataHolder dataHolder3 = (DataHolder) C0352a.m880a(parcel, B, DataHolder.CREATOR);
                    c = z;
                    dataHolder = dataHolder3;
                    break;
                case 3:
                    c = C0352a.m888c(parcel, B);
                    dataHolder = dataHolder2;
                    i = i2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    c = z;
                    dataHolder = dataHolder2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataHolder2 = dataHolder;
            z = c;
        }
        if (parcel.dataPosition() == C) {
            return new OnListEntriesResponse(i2, dataHolder2, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bB */
    public OnListEntriesResponse[] newArray(int i) {
        return new OnListEntriesResponse[i];
    }
}
