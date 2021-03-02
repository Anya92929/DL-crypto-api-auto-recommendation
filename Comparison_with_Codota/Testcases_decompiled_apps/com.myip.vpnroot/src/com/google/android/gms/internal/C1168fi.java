package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@C1130ez
/* renamed from: com.google.android.gms.internal.fi */
public final class C1168fi implements SafeParcelable {
    public static final C1170fj CREATOR = new C1170fj();
    public final ApplicationInfo applicationInfo;

    /* renamed from: lA */
    public final String f3528lA;

    /* renamed from: lD */
    public final C1230gt f3529lD;

    /* renamed from: lH */
    public final C0927ay f3530lH;

    /* renamed from: lS */
    public final List<String> f3531lS;

    /* renamed from: tA */
    public final String f3532tA;

    /* renamed from: tB */
    public final String f3533tB;

    /* renamed from: tC */
    public final Bundle f3534tC;

    /* renamed from: tD */
    public final int f3535tD;

    /* renamed from: tE */
    public final Bundle f3536tE;

    /* renamed from: tF */
    public final boolean f3537tF;

    /* renamed from: tw */
    public final Bundle f3538tw;

    /* renamed from: tx */
    public final C0924av f3539tx;

    /* renamed from: ty */
    public final PackageInfo f3540ty;

    /* renamed from: tz */
    public final String f3541tz;
    public final int versionCode;

    @C1130ez
    /* renamed from: com.google.android.gms.internal.fi$a */
    public static final class C1169a {
        public final ApplicationInfo applicationInfo;

        /* renamed from: lA */
        public final String f3542lA;

        /* renamed from: lD */
        public final C1230gt f3543lD;

        /* renamed from: lH */
        public final C0927ay f3544lH;

        /* renamed from: lS */
        public final List<String> f3545lS;

        /* renamed from: tA */
        public final String f3546tA;

        /* renamed from: tB */
        public final String f3547tB;

        /* renamed from: tC */
        public final Bundle f3548tC;

        /* renamed from: tD */
        public final int f3549tD;

        /* renamed from: tE */
        public final Bundle f3550tE;

        /* renamed from: tF */
        public final boolean f3551tF;

        /* renamed from: tw */
        public final Bundle f3552tw;

        /* renamed from: tx */
        public final C0924av f3553tx;

        /* renamed from: ty */
        public final PackageInfo f3554ty;

        public C1169a(Bundle bundle, C0924av avVar, C0927ay ayVar, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, C1230gt gtVar, Bundle bundle2, List<String> list, Bundle bundle3, boolean z) {
            this.f3552tw = bundle;
            this.f3553tx = avVar;
            this.f3544lH = ayVar;
            this.f3542lA = str;
            this.applicationInfo = applicationInfo2;
            this.f3554ty = packageInfo;
            this.f3546tA = str2;
            this.f3547tB = str3;
            this.f3543lD = gtVar;
            this.f3548tC = bundle2;
            this.f3551tF = z;
            if (list == null || list.size() <= 0) {
                this.f3549tD = 0;
                this.f3545lS = null;
            } else {
                this.f3549tD = 2;
                this.f3545lS = list;
            }
            this.f3550tE = bundle3;
        }
    }

    C1168fi(int i, Bundle bundle, C0924av avVar, C0927ay ayVar, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, C1230gt gtVar, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z) {
        this.versionCode = i;
        this.f3538tw = bundle;
        this.f3539tx = avVar;
        this.f3530lH = ayVar;
        this.f3528lA = str;
        this.applicationInfo = applicationInfo2;
        this.f3540ty = packageInfo;
        this.f3541tz = str2;
        this.f3532tA = str3;
        this.f3533tB = str4;
        this.f3529lD = gtVar;
        this.f3534tC = bundle2;
        this.f3535tD = i2;
        this.f3531lS = list;
        this.f3536tE = bundle3;
        this.f3537tF = z;
    }

    public C1168fi(Bundle bundle, C0924av avVar, C0927ay ayVar, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, C1230gt gtVar, Bundle bundle2, int i, List<String> list, Bundle bundle3, boolean z) {
        this(4, bundle, avVar, ayVar, str, applicationInfo2, packageInfo, str2, str3, str4, gtVar, bundle2, i, list, bundle3, z);
    }

    public C1168fi(C1169a aVar, String str) {
        this(aVar.f3552tw, aVar.f3553tx, aVar.f3544lH, aVar.f3542lA, aVar.applicationInfo, aVar.f3554ty, str, aVar.f3546tA, aVar.f3547tB, aVar.f3543lD, aVar.f3548tC, aVar.f3549tD, aVar.f3545lS, aVar.f3550tE, aVar.f3551tF);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1170fj.m4458a(this, out, flags);
    }
}
