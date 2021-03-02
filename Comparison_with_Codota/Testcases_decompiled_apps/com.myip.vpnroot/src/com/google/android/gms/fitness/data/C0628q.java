package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.fitness.data.q */
public class C0628q implements SafeParcelable {
    public static final Parcelable.Creator<C0628q> CREATOR = new C0629r();

    /* renamed from: BR */
    final int f1400BR;

    /* renamed from: Sk */
    private final Session f1401Sk;

    /* renamed from: Th */
    private final DataSet f1402Th;

    C0628q(int i, Session session, DataSet dataSet) {
        this.f1400BR = i;
        this.f1401Sk = session;
        this.f1402Th = dataSet;
    }

    /* renamed from: a */
    private boolean m1875a(C0628q qVar) {
        return C0345m.equal(this.f1401Sk, qVar.f1401Sk) && C0345m.equal(this.f1402Th, qVar.f1402Th);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C0628q) && m1875a((C0628q) o));
    }

    public Session getSession() {
        return this.f1401Sk;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1401Sk, this.f1402Th);
    }

    /* renamed from: iP */
    public DataSet mo5847iP() {
        return this.f1402Th;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("session", this.f1401Sk).mo4549a("dataSet", this.f1402Th).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0629r.m1877a(this, dest, flags);
    }
}
