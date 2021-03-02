package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a */
    final int f4624a;

    /* renamed from: zx */
    public final String f4625zx;

    /* renamed from: zy */
    public final int f4626zy;

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.f4624a = i;
        this.f4625zx = str;
        this.f4626zy = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m6181a(this, parcel, i);
    }
}
