package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.BleDevice;

/* renamed from: com.google.android.gms.fitness.request.c */
public class C0659c implements Parcelable.Creator<C0658b> {
    /* renamed from: a */
    static void m2007a(C0658b bVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, bVar.getDeviceAddress(), false);
        C0354b.m939c(parcel, 1000, bVar.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) bVar.mo6074iW(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bA */
    public C0658b createFromParcel(Parcel parcel) {
        BleDevice bleDevice = null;
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
                    bleDevice = (BleDevice) C0352a.m880a(parcel, B, BleDevice.CREATOR);
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
            return new C0658b(i, str, bleDevice);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cR */
    public C0658b[] newArray(int i) {
        return new C0658b[i];
    }
}
