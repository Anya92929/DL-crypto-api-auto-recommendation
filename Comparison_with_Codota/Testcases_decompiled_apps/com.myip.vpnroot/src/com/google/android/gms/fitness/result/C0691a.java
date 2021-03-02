package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.result.a */
public class C0691a implements Parcelable.Creator<BleDevicesResult> {
    /* renamed from: a */
    static void m2104a(BleDevicesResult bleDevicesResult, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, bleDevicesResult.getClaimedBleDevices(), false);
        C0354b.m939c(parcel, 1000, bleDevicesResult.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) bleDevicesResult.getStatus(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bV */
    public BleDevicesResult createFromParcel(Parcel parcel) {
        Status status = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<BleDevice> arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList = C0352a.m887c(parcel, B, BleDevice.CREATOR);
                    break;
                case 2:
                    status = (Status) C0352a.m880a(parcel, B, Status.CREATOR);
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
            return new BleDevicesResult(i, arrayList, status);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dn */
    public BleDevicesResult[] newArray(int i) {
        return new BleDevicesResult[i];
    }
}
