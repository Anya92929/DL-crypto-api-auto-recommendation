package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0164b;
import com.google.android.gms.dynamic.C0167c;

/* renamed from: com.google.android.gms.internal.bh */
public final class C0285bh implements SafeParcelable {
    public static final C0284bg CREATOR = new C0284bg();

    /* renamed from: eg */
    public final C0345co f860eg;

    /* renamed from: fR */
    public final C0279be f861fR;

    /* renamed from: fS */
    public final C0613q f862fS;

    /* renamed from: fT */
    public final C0286bi f863fT;

    /* renamed from: fU */
    public final C0347cq f864fU;

    /* renamed from: fV */
    public final C0212ag f865fV;

    /* renamed from: fW */
    public final String f866fW;

    /* renamed from: fX */
    public final boolean f867fX;

    /* renamed from: fY */
    public final String f868fY;

    /* renamed from: fZ */
    public final C0291bl f869fZ;

    /* renamed from: fz */
    public final String f870fz;

    /* renamed from: ga */
    public final int f871ga;
    public final int orientation;
    public final int versionCode;

    C0285bh(int i, C0279be beVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, C0345co coVar) {
        this.versionCode = i;
        this.f861fR = beVar;
        this.f862fS = (C0613q) C0167c.m378b(C0164b.C0165a.m377z(iBinder));
        this.f863fT = (C0286bi) C0167c.m378b(C0164b.C0165a.m377z(iBinder2));
        this.f864fU = (C0347cq) C0167c.m378b(C0164b.C0165a.m377z(iBinder3));
        this.f865fV = (C0212ag) C0167c.m378b(C0164b.C0165a.m377z(iBinder4));
        this.f866fW = str;
        this.f867fX = z;
        this.f868fY = str2;
        this.f869fZ = (C0291bl) C0167c.m378b(C0164b.C0165a.m377z(iBinder5));
        this.orientation = i2;
        this.f871ga = i3;
        this.f870fz = str3;
        this.f860eg = coVar;
    }

    public C0285bh(C0279be beVar, C0613q qVar, C0286bi biVar, C0291bl blVar, C0345co coVar) {
        this.versionCode = 1;
        this.f861fR = beVar;
        this.f862fS = qVar;
        this.f863fT = biVar;
        this.f864fU = null;
        this.f865fV = null;
        this.f866fW = null;
        this.f867fX = false;
        this.f868fY = null;
        this.f869fZ = blVar;
        this.orientation = -1;
        this.f871ga = 4;
        this.f870fz = null;
        this.f860eg = coVar;
    }

    public C0285bh(C0613q qVar, C0286bi biVar, C0212ag agVar, C0291bl blVar, C0347cq cqVar, boolean z, int i, String str, C0345co coVar) {
        this.versionCode = 1;
        this.f861fR = null;
        this.f862fS = qVar;
        this.f863fT = biVar;
        this.f864fU = cqVar;
        this.f865fV = agVar;
        this.f866fW = null;
        this.f867fX = z;
        this.f868fY = null;
        this.f869fZ = blVar;
        this.orientation = i;
        this.f871ga = 3;
        this.f870fz = str;
        this.f860eg = coVar;
    }

    public C0285bh(C0613q qVar, C0286bi biVar, C0212ag agVar, C0291bl blVar, C0347cq cqVar, boolean z, int i, String str, String str2, C0345co coVar) {
        this.versionCode = 1;
        this.f861fR = null;
        this.f862fS = qVar;
        this.f863fT = biVar;
        this.f864fU = cqVar;
        this.f865fV = agVar;
        this.f866fW = str2;
        this.f867fX = z;
        this.f868fY = str;
        this.f869fZ = blVar;
        this.orientation = i;
        this.f871ga = 3;
        this.f870fz = null;
        this.f860eg = coVar;
    }

    public C0285bh(C0613q qVar, C0286bi biVar, C0291bl blVar, C0347cq cqVar, int i, C0345co coVar) {
        this.versionCode = 1;
        this.f861fR = null;
        this.f862fS = qVar;
        this.f863fT = biVar;
        this.f864fU = cqVar;
        this.f865fV = null;
        this.f866fW = null;
        this.f867fX = false;
        this.f868fY = null;
        this.f869fZ = blVar;
        this.orientation = i;
        this.f871ga = 1;
        this.f870fz = null;
        this.f860eg = coVar;
    }

    public C0285bh(C0613q qVar, C0286bi biVar, C0291bl blVar, C0347cq cqVar, boolean z, int i, C0345co coVar) {
        this.versionCode = 1;
        this.f861fR = null;
        this.f862fS = qVar;
        this.f863fT = biVar;
        this.f864fU = cqVar;
        this.f865fV = null;
        this.f866fW = null;
        this.f867fX = z;
        this.f868fY = null;
        this.f869fZ = blVar;
        this.orientation = i;
        this.f871ga = 2;
        this.f870fz = null;
        this.f860eg = coVar;
    }

    /* renamed from: a */
    public static C0285bh m580a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(C0285bh.class.getClassLoader());
            return (C0285bh) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m581a(Intent intent, C0285bh bhVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bhVar);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: U */
    public IBinder mo4119U() {
        return C0167c.m379g(this.f862fS).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: V */
    public IBinder mo4120V() {
        return C0167c.m379g(this.f863fT).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: W */
    public IBinder mo4121W() {
        return C0167c.m379g(this.f864fU).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: X */
    public IBinder mo4122X() {
        return C0167c.m379g(this.f865fV).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Y */
    public IBinder mo4123Y() {
        return C0167c.m379g(this.f869fZ).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0284bg.m577a(this, out, flags);
    }
}
