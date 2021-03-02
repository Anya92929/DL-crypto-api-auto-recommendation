package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.signin.internal.c */
public class C1252c implements Parcelable.Creator<CheckServerAuthResult> {
    /* renamed from: a */
    static void m5197a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, checkServerAuthResult.f5277a);
        C1031c.m4619a(parcel, 2, checkServerAuthResult.f5278b);
        C1031c.m4627c(parcel, 3, checkServerAuthResult.f5279c, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public CheckServerAuthResult createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = C1029a.m4587b(parcel);
        ArrayList<Scope> arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    z = C1029a.m4591c(parcel, a);
                    break;
                case 3:
                    arrayList = C1029a.m4590c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CheckServerAuthResult(i, z, arrayList);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public CheckServerAuthResult[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }
}
