package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.c */
public class C0541c implements Parcelable.Creator<ParcelableEventList> {
    /* renamed from: a */
    static void m1551a(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, parcelableEventList.f1200BR);
        C0354b.m940c(parcel, 2, parcelableEventList.f1204me, false);
        C0354b.m923a(parcel, 3, (Parcelable) parcelableEventList.f1201Rw, i, false);
        C0354b.m930a(parcel, 4, parcelableEventList.f1202Rx);
        C0354b.m938b(parcel, 5, parcelableEventList.f1203Ry, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ba */
    public ParcelableEventList createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList<String> arrayList = null;
        int C = C0352a.m875C(parcel);
        DataHolder dataHolder = null;
        ArrayList<ParcelableEvent> arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    arrayList2 = C0352a.m887c(parcel, B, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) C0352a.m880a(parcel, B, DataHolder.CREATOR);
                    break;
                case 4:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 5:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ParcelableEventList(i, arrayList2, dataHolder, z, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cn */
    public ParcelableEventList[] newArray(int i) {
        return new ParcelableEventList[i];
    }
}
