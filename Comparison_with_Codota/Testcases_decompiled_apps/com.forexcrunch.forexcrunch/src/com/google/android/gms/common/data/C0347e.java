package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.common.data.e */
public class C0347e implements Parcelable.Creator<C0344d> {
    /* renamed from: a */
    static void m585a(C0344d dVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m678a(parcel, 1, dVar.mo4063j(), false);
        C0359b.m682c(parcel, 1000, dVar.mo4061i());
        C0359b.m677a(parcel, 2, (T[]) dVar.mo4064k(), i, false);
        C0359b.m682c(parcel, 3, dVar.getStatusCode());
        C0359b.m668a(parcel, 4, dVar.mo4065l(), false);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: a */
    public C0344d createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int c = C0357a.m634c(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    strArr = C0357a.m657w(parcel, b);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) C0357a.m633b(parcel, b, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 4:
                    bundle = C0357a.m648n(parcel, b);
                    break;
                case 1000:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() != c) {
            throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
        }
        C0344d dVar = new C0344d(i2, strArr, cursorWindowArr, i, bundle);
        dVar.mo4060h();
        return dVar;
    }

    /* renamed from: g */
    public C0344d[] newArray(int i) {
        return new C0344d[i];
    }
}
