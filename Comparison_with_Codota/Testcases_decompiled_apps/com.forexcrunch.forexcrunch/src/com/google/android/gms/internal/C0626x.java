package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.x */
public final class C0626x implements SafeParcelable {
    public static final C0627y CREATOR = new C0627y();

    /* renamed from: aJ */
    private final int f1440aJ;

    /* renamed from: ab */
    private final int f1441ab;

    /* renamed from: ci */
    private final int f1442ci;

    /* renamed from: cj */
    private final String f1443cj;

    /* renamed from: ck */
    private final String f1444ck;

    /* renamed from: cl */
    private final String f1445cl;

    /* renamed from: cm */
    private final String f1446cm;

    public C0626x(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        this.f1441ab = i;
        this.f1440aJ = i2;
        this.f1442ci = i3;
        this.f1443cj = str;
        this.f1444ck = str2;
        this.f1445cl = str3;
        this.f1446cm = str4;
    }

    /* renamed from: I */
    public int mo5497I() {
        return this.f1442ci;
    }

    /* renamed from: J */
    public String mo5498J() {
        return this.f1443cj;
    }

    /* renamed from: K */
    public String mo5499K() {
        return this.f1444ck;
    }

    /* renamed from: L */
    public String mo5500L() {
        return this.f1446cm;
    }

    /* renamed from: M */
    public boolean mo5501M() {
        return this.f1440aJ == 1 && this.f1442ci == -1;
    }

    /* renamed from: N */
    public boolean mo5502N() {
        return this.f1440aJ == 2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0626x)) {
            return false;
        }
        C0626x xVar = (C0626x) obj;
        return this.f1441ab == xVar.f1441ab && this.f1440aJ == xVar.f1440aJ && this.f1442ci == xVar.f1442ci && C0618r.m1881a(this.f1443cj, xVar.f1443cj) && C0618r.m1881a(this.f1444ck, xVar.f1444ck);
    }

    public String getDisplayName() {
        return this.f1445cl;
    }

    public int getType() {
        return this.f1440aJ;
    }

    public int hashCode() {
        return C0618r.hashCode(Integer.valueOf(this.f1441ab), Integer.valueOf(this.f1440aJ), Integer.valueOf(this.f1442ci), this.f1443cj, this.f1444ck);
    }

    /* renamed from: i */
    public int mo5508i() {
        return this.f1441ab;
    }

    public String toString() {
        if (mo5502N()) {
            return String.format("Person [%s] %s", new Object[]{mo5499K(), getDisplayName()});
        } else if (mo5501M()) {
            return String.format("Circle [%s] %s", new Object[]{mo5498J(), getDisplayName()});
        } else {
            return String.format("Group [%s] %s", new Object[]{mo5498J(), getDisplayName()});
        }
    }

    public void writeToParcel(Parcel out, int flags) {
        C0627y.m1909a(this, out, flags);
    }
}
