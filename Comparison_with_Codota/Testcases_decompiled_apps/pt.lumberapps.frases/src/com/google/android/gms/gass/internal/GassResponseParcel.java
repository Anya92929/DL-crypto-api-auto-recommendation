package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzapu;
import com.google.android.gms.internal.zzapv;

public final class GassResponseParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzd();

    /* renamed from: a */
    private zzae.zza f4803a = null;

    /* renamed from: b */
    private byte[] f4804b;
    public final int versionCode;

    GassResponseParcel(int i, byte[] bArr) {
        this.versionCode = i;
        this.f4804b = bArr;
        m6249c();
    }

    /* renamed from: a */
    private boolean m6247a() {
        return this.f4803a != null;
    }

    /* renamed from: b */
    private void m6248b() {
        if (!m6247a()) {
            try {
                this.f4803a = zzae.zza.zzc(this.f4804b);
                this.f4804b = null;
            } catch (zzapu e) {
                throw new IllegalStateException(e);
            }
        }
        m6249c();
    }

    /* renamed from: c */
    private void m6249c() {
        if (this.f4803a == null && this.f4804b != null) {
            return;
        }
        if (this.f4803a != null && this.f4804b == null) {
            return;
        }
        if (this.f4803a != null && this.f4804b != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.f4803a == null && this.f4804b == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.m6258a(this, parcel, i);
    }

    public byte[] zzblc() {
        return this.f4804b != null ? this.f4804b : zzapv.zzf(this.f4803a);
    }

    public zzae.zza zzbld() {
        m6248b();
        return this.f4803a;
    }
}
