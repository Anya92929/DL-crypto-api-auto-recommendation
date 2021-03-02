package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.Subscription;

/* renamed from: com.google.android.gms.fitness.request.af */
public class C0652af implements Parcelable.Creator<C0649ae> {
    /* renamed from: a */
    static void m1991a(C0649ae aeVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) aeVar.mo6043jB(), i, false);
        C0354b.m939c(parcel, 1000, aeVar.getVersionCode());
        C0354b.m930a(parcel, 2, aeVar.mo6044jC());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bS */
    public C0649ae createFromParcel(Parcel parcel) {
        boolean c;
        Subscription subscription;
        int i;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        Subscription subscription2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = i2;
                    Subscription subscription3 = (Subscription) C0352a.m880a(parcel, B, Subscription.CREATOR);
                    c = z;
                    subscription = subscription3;
                    break;
                case 2:
                    c = C0352a.m888c(parcel, B);
                    subscription = subscription2;
                    i = i2;
                    break;
                case 1000:
                    boolean z2 = z;
                    subscription = subscription2;
                    i = C0352a.m892g(parcel, B);
                    c = z2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    c = z;
                    subscription = subscription2;
                    i = i2;
                    break;
            }
            i2 = i;
            subscription2 = subscription;
            z = c;
        }
        if (parcel.dataPosition() == C) {
            return new C0649ae(i2, subscription2, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dk */
    public C0649ae[] newArray(int i) {
        return new C0649ae[i];
    }
}
