package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.cast.c */
public class C0264c implements Parcelable.Creator<LaunchOptions> {
    /* renamed from: a */
    static void m454a(LaunchOptions launchOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, launchOptions.getVersionCode());
        C0354b.m930a(parcel, 2, launchOptions.getRelaunchIfRunning());
        C0354b.m927a(parcel, 3, launchOptions.getLanguage(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: Z */
    public LaunchOptions[] newArray(int i) {
        return new LaunchOptions[i];
    }

    /* renamed from: v */
    public LaunchOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new LaunchOptions(i, z, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
