package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

public class ConverterWrapper implements SafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: a */
    private final int f3039a;

    /* renamed from: b */
    private final StringToIntConverter f3040b;

    ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.f3039a = i;
        this.f3040b = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.f3039a = 1;
        this.f3040b = stringToIntConverter;
    }

    public static ConverterWrapper zza(FastJsonResponse.zza<?, ?> zza) {
        if (zza instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) zza);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5614a() {
        return this.f3039a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public StringToIntConverter mo5615b() {
        return this.f3040b;
    }

    public int describeContents() {
        zza zza = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza zza = CREATOR;
        zza.m3961a(this, parcel, i);
    }

    public FastJsonResponse.zza<?, ?> zzrh() {
        if (this.f3040b != null) {
            return this.f3040b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
