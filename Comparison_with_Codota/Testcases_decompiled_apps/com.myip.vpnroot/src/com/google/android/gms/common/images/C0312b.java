package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.common.images.b */
public class C0312b implements Parcelable.Creator<WebImage> {
    /* renamed from: a */
    static void m674a(WebImage webImage, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, webImage.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) webImage.getUrl(), i, false);
        C0354b.m939c(parcel, 3, webImage.getWidth());
        C0354b.m939c(parcel, 4, webImage.getHeight());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: A */
    public WebImage createFromParcel(Parcel parcel) {
        int g;
        int i;
        Uri uri;
        int i2;
        int i3 = 0;
        int C = C0352a.m875C(parcel);
        Uri uri2 = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    int i6 = i3;
                    i = i4;
                    uri = uri2;
                    i2 = C0352a.m892g(parcel, B);
                    g = i6;
                    break;
                case 2:
                    i2 = i5;
                    int i7 = i4;
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    g = i3;
                    i = i7;
                    break;
                case 3:
                    uri = uri2;
                    i2 = i5;
                    int i8 = i3;
                    i = C0352a.m892g(parcel, B);
                    g = i8;
                    break;
                case 4:
                    g = C0352a.m892g(parcel, B);
                    i = i4;
                    uri = uri2;
                    i2 = i5;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    g = i3;
                    i = i4;
                    uri = uri2;
                    i2 = i5;
                    break;
            }
            i5 = i2;
            uri2 = uri;
            i4 = i;
            i3 = g;
        }
        if (parcel.dataPosition() == C) {
            return new WebImage(i5, uri2, i4, i3);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ax */
    public WebImage[] newArray(int i) {
        return new WebImage[i];
    }
}
