package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.cast.b */
public class C0263b implements Parcelable.Creator<CastDevice> {
    /* renamed from: a */
    static void m451a(CastDevice castDevice, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, castDevice.getVersionCode());
        C0354b.m927a(parcel, 2, castDevice.getDeviceId(), false);
        C0354b.m927a(parcel, 3, castDevice.f426ES, false);
        C0354b.m927a(parcel, 4, castDevice.getFriendlyName(), false);
        C0354b.m927a(parcel, 5, castDevice.getModelName(), false);
        C0354b.m927a(parcel, 6, castDevice.getDeviceVersion(), false);
        C0354b.m939c(parcel, 7, castDevice.getServicePort());
        C0354b.m940c(parcel, 8, castDevice.getIcons(), false);
        C0354b.m939c(parcel, 9, castDevice.getCapabilities());
        C0354b.m939c(parcel, 10, castDevice.getStatus());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: Y */
    public CastDevice[] newArray(int i) {
        return new CastDevice[i];
    }

    /* renamed from: u */
    public CastDevice createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList<WebImage> arrayList = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        int i3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i4 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 8:
                    arrayList = C0352a.m887c(parcel, B, WebImage.CREATOR);
                    break;
                case 9:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 10:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new CastDevice(i4, str5, str4, str3, str2, str, i3, arrayList, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
