package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@C1130ez
/* renamed from: com.google.android.gms.internal.av */
public final class C0924av implements SafeParcelable {
    public static final C0925aw CREATOR = new C0925aw();
    public final Bundle extras;

    /* renamed from: nT */
    public final long f2610nT;

    /* renamed from: nU */
    public final int f2611nU;

    /* renamed from: nV */
    public final List<String> f2612nV;

    /* renamed from: nW */
    public final boolean f2613nW;

    /* renamed from: nX */
    public final int f2614nX;

    /* renamed from: nY */
    public final boolean f2615nY;

    /* renamed from: nZ */
    public final String f2616nZ;

    /* renamed from: oa */
    public final C0948bj f2617oa;

    /* renamed from: ob */
    public final Location f2618ob;

    /* renamed from: oc */
    public final String f2619oc;

    /* renamed from: od */
    public final Bundle f2620od;
    public final int versionCode;

    public C0924av(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, C0948bj bjVar, Location location, String str2, Bundle bundle2) {
        this.versionCode = i;
        this.f2610nT = j;
        this.extras = bundle;
        this.f2611nU = i2;
        this.f2612nV = list;
        this.f2613nW = z;
        this.f2614nX = i3;
        this.f2615nY = z2;
        this.f2616nZ = str;
        this.f2617oa = bjVar;
        this.f2618ob = location;
        this.f2619oc = str2;
        this.f2620od = bundle2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0925aw.m3908a(this, out, flags);
    }
}
