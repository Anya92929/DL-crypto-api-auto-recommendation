package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.data.i */
public class C0616i implements Parcelable.Creator<Device> {
    /* renamed from: a */
    static void m1852a(Device device, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, device.getManufacturer(), false);
        C0354b.m939c(parcel, 1000, device.getVersionCode());
        C0354b.m927a(parcel, 2, device.getModel(), false);
        C0354b.m927a(parcel, 3, device.getVersion(), false);
        C0354b.m927a(parcel, 4, device.mo5700iN(), false);
        C0354b.m939c(parcel, 5, device.getType());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bp */
    public Device createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int C = C0352a.m875C(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 5:
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
            return new Device(i2, str4, str3, str2, str, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cG */
    public Device[] newArray(int i) {
        return new Device[i];
    }
}
