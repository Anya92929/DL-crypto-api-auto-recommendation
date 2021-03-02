package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.cp */
public class C0579cp implements Parcelable.Creator<C0578co> {
    /* renamed from: a */
    static void m1738a(C0578co coVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m672a(parcel, 1, coVar.getId(), false);
        C0359b.m682c(parcel, 1000, coVar.mo5364i());
        C0359b.m681b(parcel, 2, coVar.mo5351cB(), false);
        C0359b.m681b(parcel, 3, coVar.mo5352cC(), false);
        C0359b.m671a(parcel, 4, (Parcelable) coVar.mo5353cD(), i, false);
        C0359b.m672a(parcel, 5, coVar.mo5354cE(), false);
        C0359b.m672a(parcel, 6, coVar.mo5355cF(), false);
        C0359b.m672a(parcel, 7, coVar.mo5356cG(), false);
        C0359b.m668a(parcel, 8, coVar.mo5357cH(), false);
        C0359b.m668a(parcel, 9, coVar.mo5358cI(), false);
        C0359b.m682c(parcel, 10, coVar.mo5359cJ());
        C0359b.m663C(parcel, d);
    }

    /* renamed from: I */
    public C0578co createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int c = C0357a.m634c(parcel);
        Bundle bundle2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    str4 = C0357a.m645l(parcel, b);
                    break;
                case 2:
                    arrayList2 = C0357a.m635c(parcel, b, C0626x.CREATOR);
                    break;
                case 3:
                    arrayList = C0357a.m635c(parcel, b, Uri.CREATOR);
                    break;
                case 4:
                    uri = (Uri) C0357a.m628a(parcel, b, Uri.CREATOR);
                    break;
                case 5:
                    str3 = C0357a.m645l(parcel, b);
                    break;
                case 6:
                    str2 = C0357a.m645l(parcel, b);
                    break;
                case 7:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 8:
                    bundle2 = C0357a.m648n(parcel, b);
                    break;
                case 9:
                    bundle = C0357a.m648n(parcel, b);
                    break;
                case 10:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 1000:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0578co(i2, str4, arrayList2, arrayList, uri, str3, str2, str, bundle2, bundle, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: ai */
    public C0578co[] newArray(int i) {
        return new C0578co[i];
    }
}
