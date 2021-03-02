package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.aw */
public class C0925aw implements Parcelable.Creator<C0924av> {
    /* renamed from: a */
    static void m3908a(C0924av avVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, avVar.versionCode);
        C0354b.m919a(parcel, 2, avVar.f2610nT);
        C0354b.m920a(parcel, 3, avVar.extras, false);
        C0354b.m939c(parcel, 4, avVar.f2611nU);
        C0354b.m938b(parcel, 5, avVar.f2612nV, false);
        C0354b.m930a(parcel, 6, avVar.f2613nW);
        C0354b.m939c(parcel, 7, avVar.f2614nX);
        C0354b.m930a(parcel, 8, avVar.f2615nY);
        C0354b.m927a(parcel, 9, avVar.f2616nZ, false);
        C0354b.m923a(parcel, 10, (Parcelable) avVar.f2617oa, i, false);
        C0354b.m923a(parcel, 11, (Parcelable) avVar.f2618ob, i, false);
        C0354b.m927a(parcel, 12, avVar.f2619oc, false);
        C0354b.m920a(parcel, 13, avVar.f2620od, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: b */
    public C0924av createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        C0948bj bjVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                case 6:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 7:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 8:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 9:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 10:
                    bjVar = (C0948bj) C0352a.m880a(parcel, B, C0948bj.CREATOR);
                    break;
                case 11:
                    location = (Location) C0352a.m880a(parcel, B, Location.CREATOR);
                    break;
                case 12:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 13:
                    bundle2 = C0352a.m902q(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C0924av(i, j, bundle, i2, arrayList, z, i3, z2, str, bjVar, location, str2, bundle2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: e */
    public C0924av[] newArray(int i) {
        return new C0924av[i];
    }
}
