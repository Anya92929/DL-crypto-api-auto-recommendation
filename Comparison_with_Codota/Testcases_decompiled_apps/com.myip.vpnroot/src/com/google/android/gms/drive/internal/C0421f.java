package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.Contents;

/* renamed from: com.google.android.gms.drive.internal.f */
public class C0421f implements Parcelable.Creator<CloseContentsRequest> {
    /* renamed from: a */
    static void m1225a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, closeContentsRequest.f892BR);
        C0354b.m923a(parcel, 2, (Parcelable) closeContentsRequest.f893NX, i, false);
        C0354b.m924a(parcel, 3, closeContentsRequest.f894NZ, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: Z */
    public CloseContentsRequest createFromParcel(Parcel parcel) {
        Boolean d;
        Contents contents;
        int i;
        Boolean bool = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        Contents contents2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    Boolean bool2 = bool;
                    contents = contents2;
                    i = C0352a.m892g(parcel, B);
                    d = bool2;
                    break;
                case 2:
                    i = i2;
                    Contents contents3 = (Contents) C0352a.m880a(parcel, B, Contents.CREATOR);
                    d = bool;
                    contents = contents3;
                    break;
                case 3:
                    d = C0352a.m889d(parcel, B);
                    contents = contents2;
                    i = i2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    d = bool;
                    contents = contents2;
                    i = i2;
                    break;
            }
            i2 = i;
            contents2 = contents;
            bool = d;
        }
        if (parcel.dataPosition() == C) {
            return new CloseContentsRequest(i2, contents2, bool);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bi */
    public CloseContentsRequest[] newArray(int i) {
        return new CloseContentsRequest[i];
    }
}
