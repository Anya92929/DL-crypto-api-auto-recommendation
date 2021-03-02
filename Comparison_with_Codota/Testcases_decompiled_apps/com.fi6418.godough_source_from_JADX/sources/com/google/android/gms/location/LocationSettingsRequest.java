package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new C1154t();

    /* renamed from: a */
    private final int f4907a;

    /* renamed from: b */
    private final List<LocationRequest> f4908b;

    /* renamed from: c */
    private final boolean f4909c;

    /* renamed from: d */
    private final boolean f4910d;

    /* renamed from: e */
    private final boolean f4911e;

    LocationSettingsRequest(int i, List<LocationRequest> list, boolean z, boolean z2, boolean z3) {
        this.f4907a = i;
        this.f4908b = list;
        this.f4909c = z;
        this.f4910d = z2;
        this.f4911e = z3;
    }

    /* renamed from: a */
    public int mo7756a() {
        return this.f4907a;
    }

    /* renamed from: b */
    public List<LocationRequest> mo7757b() {
        return Collections.unmodifiableList(this.f4908b);
    }

    /* renamed from: c */
    public boolean mo7758c() {
        return this.f4909c;
    }

    /* renamed from: d */
    public boolean mo7759d() {
        return this.f4910d;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public boolean mo7761e() {
        return this.f4911e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1154t.m4986a(this, parcel, i);
    }
}
