package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.internal.aj */
public class C0396aj implements Parcelable.Creator<OnDownloadProgressResponse> {
    /* renamed from: a */
    static void m1143a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, onDownloadProgressResponse.f931BR);
        C0354b.m919a(parcel, 2, onDownloadProgressResponse.f932Ph);
        C0354b.m919a(parcel, 3, onDownloadProgressResponse.f933Pi);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: al */
    public OnDownloadProgressResponse createFromParcel(Parcel parcel) {
        long j = 0;
        int C = C0352a.m875C(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bx */
    public OnDownloadProgressResponse[] newArray(int i) {
        return new OnDownloadProgressResponse[i];
    }
}
