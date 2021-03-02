package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.mm */
public final class C1564mm implements SafeParcelable {
    public static final C1565mn CREATOR = new C1565mn();
    static final long afp = TimeUnit.HOURS.toMillis(1);

    /* renamed from: BR */
    final int f4286BR;
    private final long aeh;
    private final C1560mi afq;
    private final int mPriority;

    public C1564mm(int i, C1560mi miVar, long j, int i2) {
        this.f4286BR = i;
        this.afq = miVar;
        this.aeh = j;
        this.mPriority = i2;
    }

    public int describeContents() {
        C1565mn mnVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof C1564mm)) {
            return false;
        }
        C1564mm mmVar = (C1564mm) object;
        return C0345m.equal(this.afq, mmVar.afq) && this.aeh == mmVar.aeh && this.mPriority == mmVar.mPriority;
    }

    public long getInterval() {
        return this.aeh;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        return C0345m.hashCode(this.afq, Long.valueOf(this.aeh), Integer.valueOf(this.mPriority));
    }

    /* renamed from: mf */
    public C1560mi mo9430mf() {
        return this.afq;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("filter", this.afq).mo4549a("interval", Long.valueOf(this.aeh)).mo4549a("priority", Integer.valueOf(this.mPriority)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1565mn mnVar = CREATOR;
        C1565mn.m5620a(this, parcel, flags);
    }
}
