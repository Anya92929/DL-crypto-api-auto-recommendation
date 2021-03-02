package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsStates implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new C1156v();

    /* renamed from: a */
    private final int f4915a;

    /* renamed from: b */
    private final boolean f4916b;

    /* renamed from: c */
    private final boolean f4917c;

    /* renamed from: d */
    private final boolean f4918d;

    /* renamed from: e */
    private final boolean f4919e;

    /* renamed from: f */
    private final boolean f4920f;

    /* renamed from: g */
    private final boolean f4921g;

    /* renamed from: h */
    private final boolean f4922h;

    LocationSettingsStates(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f4915a = i;
        this.f4916b = z;
        this.f4917c = z2;
        this.f4918d = z3;
        this.f4919e = z4;
        this.f4920f = z5;
        this.f4921g = z6;
        this.f4922h = z7;
    }

    /* renamed from: a */
    public int mo7768a() {
        return this.f4915a;
    }

    /* renamed from: b */
    public boolean mo7769b() {
        return this.f4916b;
    }

    /* renamed from: c */
    public boolean mo7770c() {
        return this.f4919e;
    }

    /* renamed from: d */
    public boolean mo7771d() {
        return this.f4917c;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public boolean mo7773e() {
        return this.f4920f;
    }

    /* renamed from: f */
    public boolean mo7774f() {
        return this.f4918d;
    }

    /* renamed from: g */
    public boolean mo7775g() {
        return this.f4921g;
    }

    /* renamed from: h */
    public boolean mo7776h() {
        return this.f4922h;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1156v.m4992a(this, parcel, i);
    }
}
