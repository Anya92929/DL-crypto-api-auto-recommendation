package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.C1147m;
import com.google.android.gms.location.C1148n;
import com.google.android.gms.location.C1150p;
import com.google.android.gms.location.C1151q;

public class LocationRequestUpdateData implements SafeParcelable {
    public static final C1140t CREATOR = new C1140t();

    /* renamed from: a */
    int f4951a;

    /* renamed from: b */
    LocationRequestInternal f4952b;

    /* renamed from: c */
    C1150p f4953c;

    /* renamed from: d */
    PendingIntent f4954d;

    /* renamed from: e */
    C1147m f4955e;

    /* renamed from: f */
    private final int f4956f;

    LocationRequestUpdateData(int i, int i2, LocationRequestInternal locationRequestInternal, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2) {
        C1147m mVar = null;
        this.f4956f = i;
        this.f4951a = i2;
        this.f4952b = locationRequestInternal;
        this.f4953c = iBinder == null ? null : C1151q.m4981a(iBinder);
        this.f4954d = pendingIntent;
        this.f4955e = iBinder2 != null ? C1148n.m4977a(iBinder2) : mVar;
    }

    /* renamed from: a */
    public static LocationRequestUpdateData m4847a(C1147m mVar) {
        return new LocationRequestUpdateData(1, 2, (LocationRequestInternal) null, (IBinder) null, (PendingIntent) null, mVar.asBinder());
    }

    /* renamed from: a */
    public static LocationRequestUpdateData m4848a(C1150p pVar) {
        return new LocationRequestUpdateData(1, 2, (LocationRequestInternal) null, pVar.asBinder(), (PendingIntent) null, (IBinder) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7816a() {
        return this.f4956f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public IBinder mo7817b() {
        if (this.f4953c == null) {
            return null;
        }
        return this.f4953c.asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public IBinder mo7818c() {
        if (this.f4955e == null) {
            return null;
        }
        return this.f4955e.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1140t.m4961a(this, parcel, i);
    }
}
