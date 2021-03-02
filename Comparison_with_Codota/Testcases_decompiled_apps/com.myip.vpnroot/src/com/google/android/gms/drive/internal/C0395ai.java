package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.Contents;

/* renamed from: com.google.android.gms.drive.internal.ai */
public class C0395ai implements Parcelable.Creator<OnContentsResponse> {
    /* renamed from: a */
    static void m1140a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, onContentsResponse.f928BR);
        C0354b.m923a(parcel, 2, (Parcelable) onContentsResponse.f929Op, i, false);
        C0354b.m930a(parcel, 3, onContentsResponse.f930Pg);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ak */
    public OnContentsResponse createFromParcel(Parcel parcel) {
        boolean c;
        Contents contents;
        int i;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        Contents contents2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    boolean z2 = z;
                    contents = contents2;
                    i = C0352a.m892g(parcel, B);
                    c = z2;
                    break;
                case 2:
                    i = i2;
                    Contents contents3 = (Contents) C0352a.m880a(parcel, B, Contents.CREATOR);
                    c = z;
                    contents = contents3;
                    break;
                case 3:
                    c = C0352a.m888c(parcel, B);
                    contents = contents2;
                    i = i2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    c = z;
                    contents = contents2;
                    i = i2;
                    break;
            }
            i2 = i;
            contents2 = contents;
            z = c;
        }
        if (parcel.dataPosition() == C) {
            return new OnContentsResponse(i2, contents2, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bw */
    public OnContentsResponse[] newArray(int i) {
        return new OnContentsResponse[i];
    }
}
