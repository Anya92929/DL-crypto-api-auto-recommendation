package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.data.c */
public class C0610c implements Parcelable.Creator<BleDevice> {
    /* renamed from: a */
    static void m1834a(BleDevice bleDevice, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, bleDevice.getAddress(), false);
        C0354b.m939c(parcel, 1000, bleDevice.getVersionCode());
        C0354b.m927a(parcel, 2, bleDevice.getName(), false);
        C0354b.m938b(parcel, 3, bleDevice.getSupportedProfiles(), false);
        C0354b.m940c(parcel, 4, bleDevice.getDataTypes(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bj */
    public BleDevice createFromParcel(Parcel parcel) {
        ArrayList<DataType> arrayList = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<String> arrayList2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    arrayList2 = C0352a.m876C(parcel, B);
                    break;
                case 4:
                    arrayList = C0352a.m887c(parcel, B, DataType.CREATOR);
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
            return new BleDevice(i, str2, str, arrayList2, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cy */
    public BleDevice[] newArray(int i) {
        return new BleDevice[i];
    }
}
