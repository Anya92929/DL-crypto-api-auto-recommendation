package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.data.m */
public class C0624m implements Parcelable.Creator<RawBucket> {
    /* renamed from: a */
    static void m1863a(RawBucket rawBucket, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m919a(parcel, 1, rawBucket.f1345KL);
        C0354b.m939c(parcel, 1000, rawBucket.f1344BR);
        C0354b.m919a(parcel, 2, rawBucket.f1346Si);
        C0354b.m923a(parcel, 3, (Parcelable) rawBucket.f1347Sk, i, false);
        C0354b.m939c(parcel, 4, rawBucket.f1348Sv);
        C0354b.m940c(parcel, 5, rawBucket.f1349Sw, false);
        C0354b.m939c(parcel, 6, rawBucket.f1350Sx);
        C0354b.m930a(parcel, 7, rawBucket.f1351Sy);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: br */
    public RawBucket createFromParcel(Parcel parcel) {
        long j = 0;
        ArrayList<RawDataSet> arrayList = null;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 2:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    session = (Session) C0352a.m880a(parcel, B, Session.CREATOR);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    arrayList = C0352a.m887c(parcel, B, RawDataSet.CREATOR);
                    break;
                case 6:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 7:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 1000:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new RawBucket(i3, j2, j, session, i2, arrayList, i, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cI */
    public RawBucket[] newArray(int i) {
        return new RawBucket[i];
    }
}
