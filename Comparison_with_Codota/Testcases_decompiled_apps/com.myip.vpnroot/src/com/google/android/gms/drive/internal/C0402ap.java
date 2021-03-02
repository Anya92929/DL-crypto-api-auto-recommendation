package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.ap */
public class C0402ap implements Parcelable.Creator<OnMetadataResponse> {
    /* renamed from: a */
    static void m1161a(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, onMetadataResponse.f949BR);
        C0354b.m923a(parcel, 2, (Parcelable) onMetadataResponse.f950Od, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ar */
    public OnMetadataResponse createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0352a.m880a(parcel, B, MetadataBundle.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bD */
    public OnMetadataResponse[] newArray(int i) {
        return new OnMetadataResponse[i];
    }
}
