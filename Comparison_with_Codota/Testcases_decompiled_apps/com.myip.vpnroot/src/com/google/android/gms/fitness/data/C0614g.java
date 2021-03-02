package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.data.g */
public class C0614g implements Parcelable.Creator<DataSource> {
    /* renamed from: a */
    static void m1846a(DataSource dataSource, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) dataSource.getDataType(), i, false);
        C0354b.m939c(parcel, 1000, dataSource.getVersionCode());
        C0354b.m927a(parcel, 2, dataSource.getName(), false);
        C0354b.m939c(parcel, 3, dataSource.getType());
        C0354b.m923a(parcel, 4, (Parcelable) dataSource.getDevice(), i, false);
        C0354b.m923a(parcel, 5, (Parcelable) dataSource.mo5664iH(), i, false);
        C0354b.m927a(parcel, 6, dataSource.getStreamName(), false);
        C0354b.m930a(parcel, 7, dataSource.mo5665iJ());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bn */
    public DataSource createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int C = C0352a.m875C(parcel);
        C0608a aVar = null;
        Device device = null;
        int i = 0;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    dataType = (DataType) C0352a.m880a(parcel, B, DataType.CREATOR);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    device = (Device) C0352a.m880a(parcel, B, Device.CREATOR);
                    break;
                case 5:
                    aVar = (C0608a) C0352a.m880a(parcel, B, C0608a.CREATOR);
                    break;
                case 6:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    z = C0352a.m888c(parcel, B);
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
            return new DataSource(i2, dataType, str2, i, device, aVar, str, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cE */
    public DataSource[] newArray(int i) {
        return new DataSource[i];
    }
}
