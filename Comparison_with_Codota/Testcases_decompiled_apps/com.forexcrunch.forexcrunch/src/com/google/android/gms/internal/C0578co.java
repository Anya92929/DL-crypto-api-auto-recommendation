package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* renamed from: com.google.android.gms.internal.co */
public class C0578co implements SafeParcelable {
    public static final C0579cp CREATOR = new C0579cp();

    /* renamed from: ab */
    private final int f1342ab;

    /* renamed from: jh */
    private final String f1343jh;

    /* renamed from: kq */
    private final List<C0626x> f1344kq;

    /* renamed from: kr */
    private final List<Uri> f1345kr;

    /* renamed from: ks */
    private final Uri f1346ks;

    /* renamed from: kt */
    private final String f1347kt;

    /* renamed from: ku */
    private final String f1348ku;

    /* renamed from: kv */
    private final String f1349kv;

    /* renamed from: kw */
    private final Bundle f1350kw;

    /* renamed from: kx */
    private final Bundle f1351kx;

    /* renamed from: ky */
    private final int f1352ky;

    public C0578co(int i, String str, List<C0626x> list, List<Uri> list2, Uri uri, String str2, String str3, String str4, Bundle bundle, Bundle bundle2, int i2) {
        this.f1342ab = i;
        this.f1343jh = str;
        this.f1344kq = list;
        this.f1345kr = list2;
        this.f1346ks = uri;
        this.f1347kt = str2;
        this.f1348ku = str3;
        this.f1349kv = str4;
        this.f1350kw = bundle;
        this.f1351kx = bundle2;
        this.f1352ky = i2;
    }

    /* renamed from: cB */
    public List<C0626x> mo5351cB() {
        return this.f1344kq;
    }

    /* renamed from: cC */
    public List<Uri> mo5352cC() {
        return this.f1345kr;
    }

    /* renamed from: cD */
    public Uri mo5353cD() {
        return this.f1346ks;
    }

    /* renamed from: cE */
    public String mo5354cE() {
        return this.f1347kt;
    }

    /* renamed from: cF */
    public String mo5355cF() {
        return this.f1348ku;
    }

    /* renamed from: cG */
    public String mo5356cG() {
        return this.f1349kv;
    }

    /* renamed from: cH */
    public Bundle mo5357cH() {
        return this.f1350kw;
    }

    /* renamed from: cI */
    public Bundle mo5358cI() {
        return this.f1351kx;
    }

    /* renamed from: cJ */
    public int mo5359cJ() {
        return this.f1352ky;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0578co)) {
            return false;
        }
        C0578co coVar = (C0578co) obj;
        return this.f1342ab == coVar.f1342ab && C0618r.m1881a(this.f1344kq, coVar.f1344kq) && C0618r.m1881a(this.f1345kr, coVar.f1345kr) && C0618r.m1881a(this.f1346ks, coVar.f1346ks) && C0618r.m1881a(this.f1347kt, coVar.f1347kt) && C0618r.m1881a(this.f1348ku, coVar.f1348ku) && C0618r.m1881a(this.f1349kv, coVar.f1349kv);
    }

    public String getId() {
        return this.f1343jh;
    }

    public int hashCode() {
        return C0618r.hashCode(Integer.valueOf(this.f1342ab), this.f1344kq, this.f1345kr, this.f1346ks, this.f1347kt, this.f1348ku, this.f1349kv);
    }

    /* renamed from: i */
    public int mo5364i() {
        return this.f1342ab;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0579cp.m1738a(this, out, flags);
    }
}
