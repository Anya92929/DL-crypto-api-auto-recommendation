package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.w */
public class C1923w implements Parcelable.Creator<TileOverlayOptions> {
    /* renamed from: a */
    static void m6506a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0354b.m921a(parcel, 2, tileOverlayOptions.mo11024mP(), false);
        C0354b.m930a(parcel, 3, tileOverlayOptions.isVisible());
        C0354b.m918a(parcel, 4, tileOverlayOptions.getZIndex());
        C0354b.m930a(parcel, 5, tileOverlayOptions.getFadeIn());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cV */
    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                case 3:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 4:
                    f = C0352a.m897l(parcel, B);
                    break;
                case 5:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eK */
    public TileOverlayOptions[] newArray(int i) {
        return new TileOverlayOptions[i];
    }
}
