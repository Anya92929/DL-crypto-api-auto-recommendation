package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;

/* renamed from: com.google.android.gms.fitness.request.ae */
public class C0649ae implements SafeParcelable {
    public static final Parcelable.Creator<C0649ae> CREATOR = new C0652af();

    /* renamed from: BR */
    private final int f1515BR;

    /* renamed from: UH */
    private final Subscription f1516UH;

    /* renamed from: UI */
    private final boolean f1517UI;

    /* renamed from: com.google.android.gms.fitness.request.ae$a */
    public static class C0651a {
        /* access modifiers changed from: private */

        /* renamed from: UH */
        public Subscription f1518UH;
        /* access modifiers changed from: private */

        /* renamed from: UI */
        public boolean f1519UI = false;

        /* renamed from: b */
        public C0651a mo6047b(Subscription subscription) {
            this.f1518UH = subscription;
            return this;
        }

        /* renamed from: jD */
        public C0649ae mo6048jD() {
            C0348n.m852a(this.f1518UH != null, "Must call setSubscription()");
            return new C0649ae(this);
        }
    }

    C0649ae(int i, Subscription subscription, boolean z) {
        this.f1515BR = i;
        this.f1516UH = subscription;
        this.f1517UI = z;
    }

    private C0649ae(C0651a aVar) {
        this.f1515BR = 1;
        this.f1516UH = aVar.f1518UH;
        this.f1517UI = aVar.f1519UI;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1515BR;
    }

    /* renamed from: jB */
    public Subscription mo6043jB() {
        return this.f1516UH;
    }

    /* renamed from: jC */
    public boolean mo6044jC() {
        return this.f1517UI;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("subscription", this.f1516UH).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0652af.m1991a(this, dest, flags);
    }
}
