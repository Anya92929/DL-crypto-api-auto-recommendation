package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CheckServerAuthResult implements SafeParcelable {
    public static final Parcelable.Creator<CheckServerAuthResult> CREATOR = new C1252c();

    /* renamed from: a */
    final int f5277a;

    /* renamed from: b */
    final boolean f5278b;

    /* renamed from: c */
    final List<Scope> f5279c;

    CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        this.f5277a = i;
        this.f5278b = z;
        this.f5279c = list;
    }

    public CheckServerAuthResult(boolean z, Set<Scope> set) {
        this(1, z, m5186a(set));
    }

    /* renamed from: a */
    private static List<Scope> m5186a(Set<Scope> set) {
        return set == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(set));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1252c.m5197a(this, parcel, i);
    }
}
