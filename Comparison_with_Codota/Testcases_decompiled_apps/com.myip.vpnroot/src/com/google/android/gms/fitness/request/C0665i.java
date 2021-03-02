package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.fitness.request.i */
public class C0665i implements SafeParcelable {
    public static final Parcelable.Creator<C0665i> CREATOR = new C0666j();

    /* renamed from: BR */
    private final int f1528BR;
    private final String mName;

    C0665i(int i, String str) {
        this.f1528BR = i;
        this.mName = str;
    }

    public C0665i(String str) {
        this.f1528BR = 1;
        this.mName = str;
    }

    /* renamed from: a */
    private boolean m2025a(C0665i iVar) {
        return C0345m.equal(this.mName, iVar.mName);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C0665i) && m2025a((C0665i) o));
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1528BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.mName);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("name", this.mName).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0666j.m2026a(this, dest, flags);
    }
}
