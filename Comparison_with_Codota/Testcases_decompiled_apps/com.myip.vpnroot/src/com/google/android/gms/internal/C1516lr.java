package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.lr */
public class C1516lr implements SafeParcelable {
    public static final C1517ls CREATOR = new C1517ls();

    /* renamed from: BR */
    private final int f4271BR;
    public final String packageName;
    public final int uid;

    C1516lr(int i, int i2, String str) {
        this.f4271BR = i;
        this.uid = i2;
        this.packageName = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C1516lr)) {
            return false;
        }
        C1516lr lrVar = (C1516lr) o;
        return lrVar.uid == this.uid && C0345m.equal(lrVar.packageName, this.packageName);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4271BR;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.uid), this.packageName});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1517ls.m5463a(this, parcel, flags);
    }
}
