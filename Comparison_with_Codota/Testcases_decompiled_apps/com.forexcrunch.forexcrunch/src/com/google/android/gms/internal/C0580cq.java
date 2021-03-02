package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.cq */
public class C0580cq implements SafeParcelable {
    public static final C0581cr CREATOR = new C0581cr();

    /* renamed from: ab */
    private final int f1353ab;

    /* renamed from: kA */
    private final ArrayList<C0626x> f1354kA;

    /* renamed from: kB */
    private final Bundle f1355kB;

    /* renamed from: kC */
    private final boolean f1356kC;

    /* renamed from: ky */
    private final int f1357ky;

    /* renamed from: kz */
    private final ArrayList<C0626x> f1358kz;

    public C0580cq(int i, ArrayList<C0626x> arrayList, ArrayList<C0626x> arrayList2, Bundle bundle, boolean z, int i2) {
        this.f1353ab = i;
        this.f1358kz = arrayList;
        this.f1354kA = arrayList2;
        this.f1355kB = bundle;
        this.f1356kC = z;
        this.f1357ky = i2;
    }

    /* renamed from: cJ */
    public int mo5370cJ() {
        return this.f1357ky;
    }

    /* renamed from: cK */
    public ArrayList<C0626x> mo5371cK() {
        return this.f1358kz;
    }

    /* renamed from: cL */
    public ArrayList<C0626x> mo5372cL() {
        return this.f1354kA;
    }

    /* renamed from: cM */
    public Bundle mo5373cM() {
        return this.f1355kB;
    }

    /* renamed from: cN */
    public boolean mo5374cN() {
        return this.f1356kC;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0580cq)) {
            return false;
        }
        C0580cq cqVar = (C0580cq) obj;
        return this.f1353ab == cqVar.f1353ab && C0618r.m1881a(this.f1358kz, cqVar.f1358kz) && C0618r.m1881a(this.f1354kA, cqVar.f1354kA) && C0618r.m1881a(this.f1355kB, cqVar.f1355kB) && C0618r.m1881a(Integer.valueOf(this.f1357ky), Integer.valueOf(cqVar.f1357ky));
    }

    public int hashCode() {
        return C0618r.hashCode(Integer.valueOf(this.f1353ab), this.f1358kz, this.f1354kA, this.f1355kB, Integer.valueOf(this.f1357ky));
    }

    /* renamed from: i */
    public int mo5378i() {
        return this.f1353ab;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0581cr.m1747a(this, out, flags);
    }
}
