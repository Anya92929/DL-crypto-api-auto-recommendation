package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1447kv;

/* renamed from: com.google.android.gms.fitness.data.a */
public final class C0608a implements SafeParcelable {
    public static final Parcelable.Creator<C0608a> CREATOR = new C0609b();

    /* renamed from: Sp */
    public static final C0608a f1391Sp = new C0608a(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), (String) null);

    /* renamed from: BR */
    private final int f1392BR;

    /* renamed from: BZ */
    private final String f1393BZ;

    /* renamed from: Sq */
    private final String f1394Sq;

    /* renamed from: Sr */
    private final String f1395Sr;

    C0608a(int i, String str, String str2, String str3) {
        this.f1392BR = i;
        this.f1393BZ = (String) C0348n.m861i(str);
        this.f1394Sq = "";
        this.f1395Sr = str3;
    }

    public C0608a(String str, String str2, String str3) {
        this(1, str, "", str3);
    }

    /* renamed from: a */
    private boolean m1828a(C0608a aVar) {
        return this.f1393BZ.equals(aVar.f1393BZ) && C0345m.equal(this.f1394Sq, aVar.f1394Sq) && C0345m.equal(this.f1395Sr, aVar.f1395Sr);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof C0608a) && m1828a((C0608a) that));
    }

    public String getPackageName() {
        return this.f1393BZ;
    }

    public String getVersion() {
        return this.f1394Sq;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1392BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1393BZ, this.f1394Sq, this.f1395Sr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: iA */
    public C0608a mo5780iA() {
        return new C0608a(C1447kv.m5334bq(this.f1393BZ), C1447kv.m5334bq(this.f1394Sq), C1447kv.m5334bq(this.f1395Sr));
    }

    /* renamed from: iz */
    public String mo5781iz() {
        return this.f1395Sr;
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.f1393BZ, this.f1394Sq, this.f1395Sr});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0609b.m1831a(this, parcel, flags);
    }
}
