package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.fitness.request.x */
public class C0686x implements SafeParcelable {
    public static final Parcelable.Creator<C0686x> CREATOR = new C0689y();

    /* renamed from: BR */
    private final int f1552BR;

    /* renamed from: Tf */
    private final String f1553Tf;
    private final String mName;

    /* renamed from: com.google.android.gms.fitness.request.x$a */
    public static class C0688a {
        /* access modifiers changed from: private */

        /* renamed from: Tf */
        public String f1554Tf;
        /* access modifiers changed from: private */
        public String mName;

        /* renamed from: br */
        public C0688a mo6195br(String str) {
            this.mName = str;
            return this;
        }

        /* renamed from: bs */
        public C0688a mo6196bs(String str) {
            this.f1554Tf = str;
            return this;
        }

        /* renamed from: jy */
        public C0686x mo6197jy() {
            return new C0686x(this);
        }
    }

    C0686x(int i, String str, String str2) {
        this.f1552BR = i;
        this.mName = str;
        this.f1553Tf = str2;
    }

    private C0686x(C0688a aVar) {
        this.f1552BR = 1;
        this.mName = aVar.mName;
        this.f1553Tf = aVar.f1554Tf;
    }

    /* renamed from: a */
    private boolean m2070a(C0686x xVar) {
        return C0345m.equal(this.mName, xVar.mName) && C0345m.equal(this.f1553Tf, xVar.f1553Tf);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C0686x) && m2070a((C0686x) o));
    }

    public String getIdentifier() {
        return this.f1553Tf;
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1552BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.mName, this.f1553Tf);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("name", this.mName).mo4549a("identifier", this.f1553Tf).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0689y.m2076a(this, dest, flags);
    }
}
