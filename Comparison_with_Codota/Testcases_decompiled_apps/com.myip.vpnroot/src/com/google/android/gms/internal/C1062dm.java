package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.dynamic.C0597e;

@C1130ez
/* renamed from: com.google.android.gms.internal.dm */
public final class C1062dm implements SafeParcelable {
    public static final C1061dl CREATOR = new C1061dl();

    /* renamed from: lD */
    public final C1230gt f3174lD;
    public final int orientation;

    /* renamed from: rK */
    public final C1055dj f3175rK;

    /* renamed from: rL */
    public final C1734t f3176rL;

    /* renamed from: rM */
    public final C1063dn f3177rM;

    /* renamed from: rN */
    public final C1232gv f3178rN;

    /* renamed from: rO */
    public final C0964bw f3179rO;

    /* renamed from: rP */
    public final String f3180rP;

    /* renamed from: rQ */
    public final boolean f3181rQ;

    /* renamed from: rR */
    public final String f3182rR;

    /* renamed from: rS */
    public final C1068dq f3183rS;

    /* renamed from: rT */
    public final int f3184rT;

    /* renamed from: rU */
    public final C0975bz f3185rU;

    /* renamed from: rV */
    public final String f3186rV;

    /* renamed from: rW */
    public final C1745x f3187rW;

    /* renamed from: rq */
    public final String f3188rq;
    public final int versionCode;

    C1062dm(int i, C1055dj djVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, C1230gt gtVar, IBinder iBinder6, String str4, C1745x xVar) {
        this.versionCode = i;
        this.f3175rK = djVar;
        this.f3176rL = (C1734t) C0597e.m1742f(C0594d.C0595a.m1741am(iBinder));
        this.f3177rM = (C1063dn) C0597e.m1742f(C0594d.C0595a.m1741am(iBinder2));
        this.f3178rN = (C1232gv) C0597e.m1742f(C0594d.C0595a.m1741am(iBinder3));
        this.f3179rO = (C0964bw) C0597e.m1742f(C0594d.C0595a.m1741am(iBinder4));
        this.f3180rP = str;
        this.f3181rQ = z;
        this.f3182rR = str2;
        this.f3183rS = (C1068dq) C0597e.m1742f(C0594d.C0595a.m1741am(iBinder5));
        this.orientation = i2;
        this.f3184rT = i3;
        this.f3188rq = str3;
        this.f3174lD = gtVar;
        this.f3185rU = (C0975bz) C0597e.m1742f(C0594d.C0595a.m1741am(iBinder6));
        this.f3186rV = str4;
        this.f3187rW = xVar;
    }

    public C1062dm(C1055dj djVar, C1734t tVar, C1063dn dnVar, C1068dq dqVar, C1230gt gtVar) {
        this.versionCode = 4;
        this.f3175rK = djVar;
        this.f3176rL = tVar;
        this.f3177rM = dnVar;
        this.f3178rN = null;
        this.f3179rO = null;
        this.f3180rP = null;
        this.f3181rQ = false;
        this.f3182rR = null;
        this.f3183rS = dqVar;
        this.orientation = -1;
        this.f3184rT = 4;
        this.f3188rq = null;
        this.f3174lD = gtVar;
        this.f3185rU = null;
        this.f3186rV = null;
        this.f3187rW = null;
    }

    public C1062dm(C1734t tVar, C1063dn dnVar, C0964bw bwVar, C1068dq dqVar, C1232gv gvVar, boolean z, int i, String str, C1230gt gtVar, C0975bz bzVar) {
        this.versionCode = 4;
        this.f3175rK = null;
        this.f3176rL = tVar;
        this.f3177rM = dnVar;
        this.f3178rN = gvVar;
        this.f3179rO = bwVar;
        this.f3180rP = null;
        this.f3181rQ = z;
        this.f3182rR = null;
        this.f3183rS = dqVar;
        this.orientation = i;
        this.f3184rT = 3;
        this.f3188rq = str;
        this.f3174lD = gtVar;
        this.f3185rU = bzVar;
        this.f3186rV = null;
        this.f3187rW = null;
    }

    public C1062dm(C1734t tVar, C1063dn dnVar, C0964bw bwVar, C1068dq dqVar, C1232gv gvVar, boolean z, int i, String str, String str2, C1230gt gtVar, C0975bz bzVar) {
        this.versionCode = 4;
        this.f3175rK = null;
        this.f3176rL = tVar;
        this.f3177rM = dnVar;
        this.f3178rN = gvVar;
        this.f3179rO = bwVar;
        this.f3180rP = str2;
        this.f3181rQ = z;
        this.f3182rR = str;
        this.f3183rS = dqVar;
        this.orientation = i;
        this.f3184rT = 3;
        this.f3188rq = null;
        this.f3174lD = gtVar;
        this.f3185rU = bzVar;
        this.f3186rV = null;
        this.f3187rW = null;
    }

    public C1062dm(C1734t tVar, C1063dn dnVar, C1068dq dqVar, C1232gv gvVar, int i, C1230gt gtVar, String str, C1745x xVar) {
        this.versionCode = 4;
        this.f3175rK = null;
        this.f3176rL = tVar;
        this.f3177rM = dnVar;
        this.f3178rN = gvVar;
        this.f3179rO = null;
        this.f3180rP = null;
        this.f3181rQ = false;
        this.f3182rR = null;
        this.f3183rS = dqVar;
        this.orientation = i;
        this.f3184rT = 1;
        this.f3188rq = null;
        this.f3174lD = gtVar;
        this.f3185rU = null;
        this.f3186rV = str;
        this.f3187rW = xVar;
    }

    public C1062dm(C1734t tVar, C1063dn dnVar, C1068dq dqVar, C1232gv gvVar, boolean z, int i, C1230gt gtVar) {
        this.versionCode = 4;
        this.f3175rK = null;
        this.f3176rL = tVar;
        this.f3177rM = dnVar;
        this.f3178rN = gvVar;
        this.f3179rO = null;
        this.f3180rP = null;
        this.f3181rQ = z;
        this.f3182rR = null;
        this.f3183rS = dqVar;
        this.orientation = i;
        this.f3184rT = 2;
        this.f3188rq = null;
        this.f3174lD = gtVar;
        this.f3185rU = null;
        this.f3186rV = null;
        this.f3187rW = null;
    }

    /* renamed from: a */
    public static void m4251a(Intent intent, C1062dm dmVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", dmVar);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    /* renamed from: b */
    public static C1062dm m4252b(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(C1062dm.class.getClassLoader());
            return (C1062dm) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cc */
    public IBinder mo8334cc() {
        return C0597e.m1743k(this.f3176rL).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cd */
    public IBinder mo8335cd() {
        return C0597e.m1743k(this.f3177rM).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ce */
    public IBinder mo8336ce() {
        return C0597e.m1743k(this.f3178rN).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cf */
    public IBinder mo8337cf() {
        return C0597e.m1743k(this.f3179rO).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cg */
    public IBinder mo8338cg() {
        return C0597e.m1743k(this.f3185rU).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ch */
    public IBinder mo8339ch() {
        return C0597e.m1743k(this.f3183rS).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1061dl.m4248a(this, out, flags);
    }
}
