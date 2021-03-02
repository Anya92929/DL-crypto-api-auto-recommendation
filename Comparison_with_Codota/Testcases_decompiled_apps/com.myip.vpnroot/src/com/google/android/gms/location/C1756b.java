package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.location.b */
public class C1756b implements Parcelable.Creator<LocationRequest> {
    /* renamed from: a */
    static void m6250a(LocationRequest locationRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, locationRequest.mPriority);
        C0354b.m939c(parcel, 1000, locationRequest.getVersionCode());
        C0354b.m919a(parcel, 2, locationRequest.aeh);
        C0354b.m919a(parcel, 3, locationRequest.aei);
        C0354b.m930a(parcel, 4, locationRequest.f4419Uz);
        C0354b.m919a(parcel, 5, locationRequest.adX);
        C0354b.m939c(parcel, 6, locationRequest.aej);
        C0354b.m918a(parcel, 7, locationRequest.aek);
        C0354b.m919a(parcel, 8, locationRequest.ael);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cs */
    public LocationRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        int i2 = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 5:
                    j3 = C0352a.m894i(parcel, B);
                    break;
                case 6:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 7:
                    f = C0352a.m897l(parcel, B);
                    break;
                case 8:
                    j4 = C0352a.m894i(parcel, B);
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
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ec */
    public LocationRequest[] newArray(int i) {
        return new LocationRequest[i];
    }
}
