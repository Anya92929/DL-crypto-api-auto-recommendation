package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.a */
public class C2225a implements Parcelable.Creator<Asset> {
    /* renamed from: a */
    static void m7480a(Asset asset, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, asset.f4650BR);
        C0354b.m931a(parcel, 2, asset.getData(), false);
        C0354b.m927a(parcel, 3, asset.getDigest(), false);
        C0354b.m923a(parcel, 4, (Parcelable) asset.auG, i, false);
        C0354b.m923a(parcel, 5, (Parcelable) asset.uri, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dP */
    public Asset createFromParcel(Parcel parcel) {
        Uri uri = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    bArr = C0352a.m903r(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0352a.m880a(parcel, B, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fR */
    public Asset[] newArray(int i) {
        return new Asset[i];
    }
}
