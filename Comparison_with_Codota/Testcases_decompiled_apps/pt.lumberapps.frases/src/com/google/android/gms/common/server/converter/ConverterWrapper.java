package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

public class ConverterWrapper extends AbstractSafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a */
    private final int f4627a;

    /* renamed from: b */
    private final StringToIntConverter f4628b;

    ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.f4627a = i;
        this.f4628b = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.f4627a = 1;
        this.f4628b = stringToIntConverter;
    }

    public static ConverterWrapper zza(FastJsonResponse.zza zza) {
        if (zza instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) zza);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6775a() {
        return this.f4627a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public StringToIntConverter mo6776b() {
        return this.f4628b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza zza = CREATOR;
        zza.m6149a(this, parcel, i);
    }

    public FastJsonResponse.zza zzatr() {
        if (this.f4628b != null) {
            return this.f4628b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
