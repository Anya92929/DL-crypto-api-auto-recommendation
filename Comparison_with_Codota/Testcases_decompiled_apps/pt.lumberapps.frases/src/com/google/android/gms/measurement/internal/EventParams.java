package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;

public class EventParams extends AbstractSafeParcelable implements Iterable {
    public static final zzj CREATOR = new zzj();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Bundle f7064a;
    public final int versionCode;

    EventParams(int i, Bundle bundle) {
        this.versionCode = i;
        this.f7064a = bundle;
    }

    EventParams(Bundle bundle) {
        zzab.zzy(bundle);
        this.f7064a = bundle;
        this.versionCode = 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo9201a(String str) {
        return this.f7064a.get(str);
    }

    public Iterator iterator() {
        return new C1882a(this);
    }

    public int size() {
        return this.f7064a.size();
    }

    public String toString() {
        return this.f7064a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.m7885a(this, parcel, i);
    }

    public Bundle zzbss() {
        return new Bundle(this.f7064a);
    }
}
