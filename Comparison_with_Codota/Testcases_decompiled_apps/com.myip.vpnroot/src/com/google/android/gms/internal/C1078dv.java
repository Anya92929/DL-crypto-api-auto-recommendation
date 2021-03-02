package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.dynamic.C0597e;

@C1130ez
/* renamed from: com.google.android.gms.internal.dv */
public final class C1078dv implements SafeParcelable {
    public static final C1077du CREATOR = new C1077du();

    /* renamed from: lM */
    public final C1107el f3205lM;

    /* renamed from: lT */
    public final C1090ee f3206lT;

    /* renamed from: si */
    public final C1092eg f3207si;

    /* renamed from: sj */
    public final Context f3208sj;
    public final int versionCode;

    C1078dv(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.f3205lM = (C1107el) C0597e.m1742f(C0594d.C0595a.m1741am(iBinder));
        this.f3206lT = (C1090ee) C0597e.m1742f(C0594d.C0595a.m1741am(iBinder2));
        this.f3207si = (C1092eg) C0597e.m1742f(C0594d.C0595a.m1741am(iBinder3));
        this.f3208sj = (Context) C0597e.m1742f(C0594d.C0595a.m1741am(iBinder4));
    }

    public C1078dv(C1092eg egVar, C1107el elVar, C1090ee eeVar, Context context) {
        this.versionCode = 1;
        this.f3207si = egVar;
        this.f3205lM = elVar;
        this.f3206lT = eeVar;
        this.f3208sj = context;
    }

    /* renamed from: a */
    public static void m4288a(Intent intent, C1078dv dvVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", dvVar);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    /* renamed from: c */
    public static C1078dv m4289c(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(C1078dv.class.getClassLoader());
            return (C1078dv) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cl */
    public IBinder mo8373cl() {
        return C0597e.m1743k(this.f3205lM).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cm */
    public IBinder mo8374cm() {
        return C0597e.m1743k(this.f3206lT).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cn */
    public IBinder mo8375cn() {
        return C0597e.m1743k(this.f3207si).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: co */
    public IBinder mo8376co() {
        return C0597e.m1743k(this.f3208sj).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1077du.m4285a(this, out, flags);
    }
}
