package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.data.u */
public class C0632u implements Parcelable.Creator<Value> {
    /* renamed from: a */
    static void m1884a(Value value, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, value.getFormat());
        C0354b.m939c(parcel, 1000, value.getVersionCode());
        C0354b.m930a(parcel, 2, value.isSet());
        C0354b.m918a(parcel, 3, value.mo5768iS());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bx */
    public Value createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 3:
                    f = C0352a.m897l(parcel, B);
                    break;
                case 1000:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new Value(i2, i, z, f);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cO */
    public Value[] newArray(int i) {
        return new Value[i];
    }
}
