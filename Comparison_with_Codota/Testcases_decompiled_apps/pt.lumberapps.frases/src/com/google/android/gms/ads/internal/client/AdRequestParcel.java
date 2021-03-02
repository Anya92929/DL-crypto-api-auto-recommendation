package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzin;
import java.util.List;

@zzin
public final class AdRequestParcel extends AbstractSafeParcelable {
    public static final zzg CREATOR = new zzg();
    public final Bundle extras;
    public final int versionCode;
    public final long zzatm;
    public final int zzatn;
    public final List zzato;
    public final boolean zzatp;
    public final int zzatq;
    public final boolean zzatr;
    public final String zzats;
    public final SearchAdRequestParcel zzatt;
    public final Location zzatu;
    public final String zzatv;
    public final Bundle zzatw;
    public final Bundle zzatx;
    public final List zzaty;
    public final String zzatz;
    public final String zzaua;
    public final boolean zzaub;

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List list2, String str3, String str4, boolean z3) {
        this.versionCode = i;
        this.zzatm = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzatn = i2;
        this.zzato = list;
        this.zzatp = z;
        this.zzatq = i3;
        this.zzatr = z2;
        this.zzats = str;
        this.zzatt = searchAdRequestParcel;
        this.zzatu = location;
        this.zzatv = str2;
        this.zzatw = bundle2 == null ? new Bundle() : bundle2;
        this.zzatx = bundle3;
        this.zzaty = list2;
        this.zzatz = str3;
        this.zzaua = str4;
        this.zzaub = z3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.versionCode == adRequestParcel.versionCode && this.zzatm == adRequestParcel.zzatm && zzaa.equal(this.extras, adRequestParcel.extras) && this.zzatn == adRequestParcel.zzatn && zzaa.equal(this.zzato, adRequestParcel.zzato) && this.zzatp == adRequestParcel.zzatp && this.zzatq == adRequestParcel.zzatq && this.zzatr == adRequestParcel.zzatr && zzaa.equal(this.zzats, adRequestParcel.zzats) && zzaa.equal(this.zzatt, adRequestParcel.zzatt) && zzaa.equal(this.zzatu, adRequestParcel.zzatu) && zzaa.equal(this.zzatv, adRequestParcel.zzatv) && zzaa.equal(this.zzatw, adRequestParcel.zzatw) && zzaa.equal(this.zzatx, adRequestParcel.zzatx) && zzaa.equal(this.zzaty, adRequestParcel.zzaty) && zzaa.equal(this.zzatz, adRequestParcel.zzatz) && zzaa.equal(this.zzaua, adRequestParcel.zzaua) && this.zzaub == adRequestParcel.zzaub;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzatm), this.extras, Integer.valueOf(this.zzatn), this.zzato, Boolean.valueOf(this.zzatp), Integer.valueOf(this.zzatq), Boolean.valueOf(this.zzatr), this.zzats, this.zzatt, this.zzatu, this.zzatv, this.zzatw, this.zzatx, this.zzaty, this.zzatz, this.zzaua, Boolean.valueOf(this.zzaub));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.m5600a(this, parcel, i);
    }
}
