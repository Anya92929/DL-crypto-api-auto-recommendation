package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;

/* renamed from: com.google.android.gms.fitness.request.v */
public class C0682v implements SafeParcelable {
    public static final Parcelable.Creator<C0682v> CREATOR = new C0685w();

    /* renamed from: BR */
    private final int f1549BR;

    /* renamed from: Sk */
    private final Session f1550Sk;

    /* renamed from: com.google.android.gms.fitness.request.v$a */
    public static class C0684a {
        /* access modifiers changed from: private */

        /* renamed from: Sk */
        public Session f1551Sk;

        /* renamed from: b */
        public C0684a mo6181b(Session session) {
            C0348n.m859b(session.getEndTimeMillis() == 0, (Object) "Cannot start a session which has already ended");
            this.f1551Sk = session;
            return this;
        }

        /* renamed from: jx */
        public C0682v mo6182jx() {
            return new C0682v(this);
        }
    }

    C0682v(int i, Session session) {
        this.f1549BR = i;
        this.f1550Sk = session;
    }

    private C0682v(C0684a aVar) {
        this.f1549BR = 1;
        this.f1550Sk = aVar.f1551Sk;
    }

    /* renamed from: a */
    private boolean m2063a(C0682v vVar) {
        return C0345m.equal(this.f1550Sk, vVar.f1550Sk);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C0682v) && m2063a((C0682v) o));
    }

    public Session getSession() {
        return this.f1550Sk;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1549BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1550Sk);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("session", this.f1550Sk).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0685w.m2067a(this, dest, flags);
    }
}
