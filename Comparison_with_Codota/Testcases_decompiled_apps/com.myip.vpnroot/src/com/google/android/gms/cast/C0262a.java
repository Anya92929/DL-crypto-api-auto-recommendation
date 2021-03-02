package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.cast.a */
public class C0262a implements Parcelable.Creator<ApplicationMetadata> {
    /* renamed from: a */
    static void m448a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, applicationMetadata.getVersionCode());
        C0354b.m927a(parcel, 2, applicationMetadata.getApplicationId(), false);
        C0354b.m927a(parcel, 3, applicationMetadata.getName(), false);
        C0354b.m940c(parcel, 4, applicationMetadata.getImages(), false);
        C0354b.m938b(parcel, 5, applicationMetadata.f392EB, false);
        C0354b.m927a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        C0354b.m923a(parcel, 7, (Parcelable) applicationMetadata.mo3883fv(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: U */
    public ApplicationMetadata[] newArray(int i) {
        return new ApplicationMetadata[i];
    }

    /* renamed from: t */
    public ApplicationMetadata createFromParcel(Parcel parcel) {
        Uri uri = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        ArrayList<WebImage> arrayList2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    arrayList2 = C0352a.m887c(parcel, B, WebImage.CREATOR);
                    break;
                case 5:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                case 6:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ApplicationMetadata(i, str3, str2, arrayList2, arrayList, str, uri);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
