package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal implements SafeParcelable {
    public static final C1139s CREATOR = new C1139s();

    /* renamed from: a */
    static final List<ClientIdentity> f4942a = Collections.emptyList();

    /* renamed from: b */
    LocationRequest f4943b;

    /* renamed from: c */
    boolean f4944c;

    /* renamed from: d */
    boolean f4945d;

    /* renamed from: e */
    boolean f4946e;

    /* renamed from: f */
    List<ClientIdentity> f4947f;

    /* renamed from: g */
    final String f4948g;

    /* renamed from: h */
    boolean f4949h;

    /* renamed from: i */
    private final int f4950i;

    LocationRequestInternal(int i, LocationRequest locationRequest, boolean z, boolean z2, boolean z3, List<ClientIdentity> list, String str, boolean z4) {
        this.f4950i = i;
        this.f4943b = locationRequest;
        this.f4944c = z;
        this.f4945d = z2;
        this.f4946e = z3;
        this.f4947f = list;
        this.f4948g = str;
        this.f4949h = z4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7810a() {
        return this.f4950i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationRequestInternal)) {
            return false;
        }
        LocationRequestInternal locationRequestInternal = (LocationRequestInternal) obj;
        return C1006bc.m4525a(this.f4943b, locationRequestInternal.f4943b) && this.f4944c == locationRequestInternal.f4944c && this.f4945d == locationRequestInternal.f4945d && this.f4946e == locationRequestInternal.f4946e && this.f4949h == locationRequestInternal.f4949h && C1006bc.m4525a(this.f4947f, locationRequestInternal.f4947f);
    }

    public int hashCode() {
        return this.f4943b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4943b.toString());
        sb.append(" requestNlpDebugInfo=");
        sb.append(this.f4944c);
        sb.append(" restorePendingIntentListeners=");
        sb.append(this.f4945d);
        sb.append(" triggerUpdate=");
        sb.append(this.f4946e);
        sb.append(" hideFromAppOps=");
        sb.append(this.f4949h);
        sb.append(" clients=");
        sb.append(this.f4947f);
        if (this.f4948g != null) {
            sb.append(" tag=");
            sb.append(this.f4948g);
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1139s.m4958a(this, parcel, i);
    }
}
