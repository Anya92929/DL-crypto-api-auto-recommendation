package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.result.e */
public class C0695e implements Parcelable.Creator<ListSubscriptionsResult> {
    /* renamed from: a */
    static void m2116a(ListSubscriptionsResult listSubscriptionsResult, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, listSubscriptionsResult.getSubscriptions(), false);
        C0354b.m939c(parcel, 1000, listSubscriptionsResult.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) listSubscriptionsResult.getStatus(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bZ */
    public ListSubscriptionsResult createFromParcel(Parcel parcel) {
        Status status = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<Subscription> arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList = C0352a.m887c(parcel, B, Subscription.CREATOR);
                    break;
                case 2:
                    status = (Status) C0352a.m880a(parcel, B, Status.CREATOR);
                    break;
                case 1000:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ListSubscriptionsResult(i, arrayList, status);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dr */
    public ListSubscriptionsResult[] newArray(int i) {
        return new ListSubscriptionsResult[i];
    }
}
