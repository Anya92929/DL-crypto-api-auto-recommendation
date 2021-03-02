package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public class UserAttributeParcel extends AbstractSafeParcelable {
    public static final zzaj CREATOR = new zzaj();
    public final String aiJ;
    public final long amt;
    public final Long amu;
    public final Float amv;
    public final Double amw;
    public final String name;
    public final int versionCode;

    /* renamed from: zD */
    public final String f7065zD;

    UserAttributeParcel(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        Double d2 = null;
        this.versionCode = i;
        this.name = str;
        this.amt = j;
        this.amu = l;
        this.amv = null;
        if (i == 1) {
            this.amw = f != null ? Double.valueOf(f.doubleValue()) : d2;
        } else {
            this.amw = d;
        }
        this.f7065zD = str2;
        this.aiJ = str3;
    }

    UserAttributeParcel(C1888af afVar) {
        this(afVar.f7082b, afVar.f7083c, afVar.f7084d, afVar.f7081a);
    }

    UserAttributeParcel(String str, long j, Object obj, String str2) {
        zzab.zzhr(str);
        this.versionCode = 2;
        this.name = str;
        this.amt = j;
        this.aiJ = str2;
        if (obj == null) {
            this.amu = null;
            this.amv = null;
            this.amw = null;
            this.f7065zD = null;
        } else if (obj instanceof Long) {
            this.amu = (Long) obj;
            this.amv = null;
            this.amw = null;
            this.f7065zD = null;
        } else if (obj instanceof String) {
            this.amu = null;
            this.amv = null;
            this.amw = null;
            this.f7065zD = (String) obj;
        } else if (obj instanceof Double) {
            this.amu = null;
            this.amv = null;
            this.amw = (Double) obj;
            this.f7065zD = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public Object getValue() {
        if (this.amu != null) {
            return this.amu;
        }
        if (this.amw != null) {
            return this.amw;
        }
        if (this.f7065zD != null) {
            return this.f7065zD;
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaj.m7790a(this, parcel, i);
    }
}
