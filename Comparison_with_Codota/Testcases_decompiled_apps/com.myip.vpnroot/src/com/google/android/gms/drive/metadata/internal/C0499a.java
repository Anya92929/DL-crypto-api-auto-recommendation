package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.a */
public class C0499a implements Parcelable.Creator<AppVisibleCustomProperties> {
    /* renamed from: a */
    static void m1390a(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, appVisibleCustomProperties.f1098BR);
        C0354b.m940c(parcel, 2, appVisibleCustomProperties.f1099Pz, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aF */
    public AppVisibleCustomProperties createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<CustomProperty> arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    arrayList = C0352a.m887c(parcel, B, CustomProperty.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new AppVisibleCustomProperties(i, (Collection<CustomProperty>) arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bR */
    public AppVisibleCustomProperties[] newArray(int i) {
        return new AppVisibleCustomProperties[i];
    }
}
