package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.dl */
public class C1061dl implements Parcelable.Creator<C1062dm> {
    /* renamed from: a */
    static void m4248a(C1062dm dmVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, dmVar.versionCode);
        C0354b.m923a(parcel, 2, (Parcelable) dmVar.f3175rK, i, false);
        C0354b.m921a(parcel, 3, dmVar.mo8334cc(), false);
        C0354b.m921a(parcel, 4, dmVar.mo8335cd(), false);
        C0354b.m921a(parcel, 5, dmVar.mo8336ce(), false);
        C0354b.m921a(parcel, 6, dmVar.mo8337cf(), false);
        C0354b.m927a(parcel, 7, dmVar.f3180rP, false);
        C0354b.m930a(parcel, 8, dmVar.f3181rQ);
        C0354b.m927a(parcel, 9, dmVar.f3182rR, false);
        C0354b.m921a(parcel, 10, dmVar.mo8339ch(), false);
        C0354b.m939c(parcel, 11, dmVar.orientation);
        C0354b.m939c(parcel, 12, dmVar.f3184rT);
        C0354b.m927a(parcel, 13, dmVar.f3188rq, false);
        C0354b.m923a(parcel, 14, (Parcelable) dmVar.f3174lD, i, false);
        C0354b.m921a(parcel, 15, dmVar.mo8338cg(), false);
        C0354b.m923a(parcel, 17, (Parcelable) dmVar.f3187rW, i, false);
        C0354b.m927a(parcel, 16, dmVar.f3186rV, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: f */
    public C1062dm createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        C1055dj djVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        C1230gt gtVar = null;
        IBinder iBinder6 = null;
        String str4 = null;
        C1745x xVar = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    djVar = (C1055dj) C0352a.m880a(parcel, B, C1055dj.CREATOR);
                    break;
                case 3:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                case 4:
                    iBinder2 = C0352a.m901p(parcel, B);
                    break;
                case 5:
                    iBinder3 = C0352a.m901p(parcel, B);
                    break;
                case 6:
                    iBinder4 = C0352a.m901p(parcel, B);
                    break;
                case 7:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 9:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 10:
                    iBinder5 = C0352a.m901p(parcel, B);
                    break;
                case 11:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 12:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 13:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 14:
                    gtVar = (C1230gt) C0352a.m880a(parcel, B, C1230gt.CREATOR);
                    break;
                case 15:
                    iBinder6 = C0352a.m901p(parcel, B);
                    break;
                case 16:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 17:
                    xVar = (C1745x) C0352a.m880a(parcel, B, C1745x.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1062dm(i, djVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, gtVar, iBinder6, str4, xVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: m */
    public C1062dm[] newArray(int i) {
        return new C1062dm[i];
    }
}
