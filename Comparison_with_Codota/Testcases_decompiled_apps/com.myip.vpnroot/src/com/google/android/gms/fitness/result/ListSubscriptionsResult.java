package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSubscriptionsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new C0695e();

    /* renamed from: BR */
    private final int f1572BR;

    /* renamed from: CM */
    private final Status f1573CM;

    /* renamed from: UN */
    private final List<Subscription> f1574UN;

    ListSubscriptionsResult(int versionCode, List<Subscription> subscriptions, Status status) {
        this.f1572BR = versionCode;
        this.f1574UN = subscriptions;
        this.f1573CM = status;
    }

    public ListSubscriptionsResult(List<Subscription> subscriptions, Status status) {
        this.f1572BR = 3;
        this.f1574UN = Collections.unmodifiableList(subscriptions);
        this.f1573CM = (Status) C0348n.m857b(status, (Object) "status");
    }

    /* renamed from: G */
    public static ListSubscriptionsResult m2097G(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    /* renamed from: b */
    private boolean m2098b(ListSubscriptionsResult listSubscriptionsResult) {
        return this.f1573CM.equals(listSubscriptionsResult.f1573CM) && C0345m.equal(this.f1574UN, listSubscriptionsResult.f1574UN);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof ListSubscriptionsResult) && m2098b((ListSubscriptionsResult) that));
    }

    public Status getStatus() {
        return this.f1573CM;
    }

    public List<Subscription> getSubscriptions() {
        return this.f1574UN;
    }

    public List<Subscription> getSubscriptions(DataType dataType) {
        ArrayList<Subscription> arrayList = new ArrayList<>();
        for (Subscription subscription : arrayList) {
            if (subscription.getDataType().equals(dataType)) {
                arrayList.add(subscription);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1572BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1573CM, this.f1574UN);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("status", this.f1573CM).mo4549a("dataSets", this.f1574UN).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0695e.m2116a(this, dest, flags);
    }
}
