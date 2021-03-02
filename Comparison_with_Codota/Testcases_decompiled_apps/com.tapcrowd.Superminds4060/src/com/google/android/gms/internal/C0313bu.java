package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.bu */
public final class C0313bu implements SafeParcelable {
    public static final C0315bv CREATOR = new C0315bv();
    public final String adUnitId;
    public final ApplicationInfo applicationInfo;

    /* renamed from: ed */
    public final C0622x f911ed;

    /* renamed from: eg */
    public final C0345co f912eg;

    /* renamed from: gA */
    public final Bundle f913gA;

    /* renamed from: gB */
    public final C0620v f914gB;

    /* renamed from: gC */
    public final PackageInfo f915gC;

    /* renamed from: gD */
    public final String f916gD;

    /* renamed from: gE */
    public final String f917gE;

    /* renamed from: gF */
    public final String f918gF;
    public final int versionCode;

    /* renamed from: com.google.android.gms.internal.bu$a */
    public static final class C0314a {
        public final String adUnitId;
        public final ApplicationInfo applicationInfo;

        /* renamed from: ed */
        public final C0622x f919ed;

        /* renamed from: eg */
        public final C0345co f920eg;

        /* renamed from: gA */
        public final Bundle f921gA;

        /* renamed from: gB */
        public final C0620v f922gB;

        /* renamed from: gC */
        public final PackageInfo f923gC;

        /* renamed from: gE */
        public final String f924gE;

        /* renamed from: gF */
        public final String f925gF;

        public C0314a(Bundle bundle, C0620v vVar, C0622x xVar, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, C0345co coVar) {
            this.f921gA = bundle;
            this.f922gB = vVar;
            this.f919ed = xVar;
            this.adUnitId = str;
            this.applicationInfo = applicationInfo2;
            this.f923gC = packageInfo;
            this.f924gE = str2;
            this.f925gF = str3;
            this.f920eg = coVar;
        }
    }

    C0313bu(int i, Bundle bundle, C0620v vVar, C0622x xVar, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, C0345co coVar) {
        this.versionCode = i;
        this.f913gA = bundle;
        this.f914gB = vVar;
        this.f911ed = xVar;
        this.adUnitId = str;
        this.applicationInfo = applicationInfo2;
        this.f915gC = packageInfo;
        this.f916gD = str2;
        this.f917gE = str3;
        this.f918gF = str4;
        this.f912eg = coVar;
    }

    public C0313bu(Bundle bundle, C0620v vVar, C0622x xVar, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, C0345co coVar) {
        this(1, bundle, vVar, xVar, str, applicationInfo2, packageInfo, str2, str3, str4, coVar);
    }

    public C0313bu(C0314a aVar, String str) {
        this(aVar.f921gA, aVar.f922gB, aVar.f919ed, aVar.adUnitId, aVar.applicationInfo, aVar.f923gC, str, aVar.f924gE, aVar.f925gF, aVar.f920eg);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0315bv.m644a(this, out, flags);
    }
}
