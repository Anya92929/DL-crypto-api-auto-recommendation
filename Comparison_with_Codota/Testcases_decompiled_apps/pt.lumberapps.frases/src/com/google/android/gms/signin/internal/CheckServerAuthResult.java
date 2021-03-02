package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class CheckServerAuthResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();

    /* renamed from: a */
    final int f7410a;

    /* renamed from: b */
    final boolean f7411b;

    /* renamed from: c */
    final List f7412c;

    CheckServerAuthResult(int i, boolean z, List list) {
        this.f7410a = i;
        this.f7411b = z;
        this.f7412c = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m8027a(this, parcel, i);
    }
}
